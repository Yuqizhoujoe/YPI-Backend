package com.itlize.korera.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "projects")
public class Project {

    // constructor
    public Project() {}

    // projectId
    @Id
    @Column(name = "ProjectId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProjectId;
    public int getProjectId() {
        return ProjectId;
    }

    // ProjectName
    @Column(name = "ProjectName", nullable = false)
    private String ProjectName;
    public String getProjectName() {
        return this.ProjectName;
    }
    public void setProjectName(String projectName) {
        this.ProjectName = projectName;
    }

    // ProjectResource
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // the mappedBy tells Hibernate look at the instructor property in the ProjectResource class
    // use information from the ProjectResource class @JoinColumn
    // to help find associated ProjectResource for Project
    @JsonIgnore
    private List<ProjectResource> ProjectResources;

    @Override
    public String toString() {
        return "Project{" +
                "ProjectId=" + ProjectId +
                ", ProjectName='" + ProjectName + '\'' + '}';
    }

    /*
    // getter
    @JsonIgnore
    public List<ProjectResource> getProjectResources() {
        // force clients through the add and remove methods
        return Collections.unmodifiableList(ProjectResources);
    }
    // add ProjectResource
    public void addProjectResource(ProjectResource projectResource){
        // if is null, create a empty list
        if (ProjectResources == null) {
            ProjectResources = new ArrayList<>();
        }
        // avoid circular calls : assumes equals and hashcode implemented
        if (!ProjectResources.contains(projectResource)) {
            ProjectResources.add(projectResource);
            projectResource.setProject(this);
        }
    }
    // remove ProjectResource
    public void removeProjectResource(ProjectResource projectResource) {
        if (!ProjectResources.contains(projectResource)) {
            ProjectResources.remove(projectResource);
            projectResource.setProject(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;

        Project project = (Project) o;

        if (ProjectId != project.ProjectId) return false;
        if (ProjectName != null ? !ProjectName.equals(project.ProjectName) : project.ProjectName != null) return false;
        return ProjectResources != null ? ProjectResources.equals(project.ProjectResources) : project.ProjectResources == null;
    }

    @Override
    public int hashCode() {
        int result = ProjectId;
        result = 31 * result + (ProjectName != null ? ProjectName.hashCode() : 0);
        result = 31 * result + (ProjectResources != null ? ProjectResources.hashCode() : 0);
        return result;
    }*/

}
