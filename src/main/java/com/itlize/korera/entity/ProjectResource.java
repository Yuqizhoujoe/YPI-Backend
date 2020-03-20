package com.itlize.korera.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Table(name = "project_resource")
public class ProjectResource {

    // constructor
    public ProjectResource(){}

    public ProjectResource(int projectResourceId){
        this.ProjectResourceId = projectResourceId;
    }

    // ProjectResourceId
    @Id
    @Column(name = "ProjectResourceId", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProjectResourceId;
    public int getProjectResourceId() {
        return ProjectResourceId;
    }
    public void setProjectResourceId(int projectResourceId) {
        ProjectResourceId = projectResourceId;
    }

    // Resource
    @ManyToOne(cascade = {
            CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "ResourceId")
    private Resource resource;
    public Resource getResource() {
        return resource;
    }
    public void setResource(Resource resource) {
        this.resource = resource;
    }

    // Project
    @ManyToOne(cascade = {
            CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "ProjectId")
    private Project project;
    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProjectResource)) return false;

        ProjectResource that = (ProjectResource) o;

        if (ProjectResourceId != that.ProjectResourceId) return false;
        if (resource != null ? !resource.equals(that.resource) : that.resource != null) return false;
        return project != null ? project.equals(that.project) : that.project == null;
    }


    @Override
    public String toString() {
        return "ProjectResource{" +
                "ProjectResourceId=" + ProjectResourceId +
                ", resource=" + resource.getResourceId() +
                ", project=" + project.getProjectId() +
                '}';
    }
}
