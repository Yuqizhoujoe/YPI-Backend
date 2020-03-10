package com.itlize.korera.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "resources")
public class Resource {

    // constructor
    public Resource() { }

    public Resource(int ResourceId) {
        this.ResourceId = ResourceId;
    }

    // ResourceId
    @Id
    @Column(name = "ResourceId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ResourceId;
    public int getResourceId() {
        return this.ResourceId;
    }
    public void setResourceId(int resourceId) {
        ResourceId = resourceId;
    }

    // ResourceName
    @Column(name = "ResourceName", nullable = false, unique = true)
    private String ResourceName;
    public String getResourceName() {
        return this.ResourceName;
    }
    public void setResourceName(String resourceName) {
        this.ResourceName = resourceName;
    }

    // Cost_Code
    @Column(name = "Cost_Code", nullable = false, unique = true)
    private String Cost_Code;
    public String getCost_Code() {
        return this.Cost_Code;
    }
    public void setCost_Code(String cost_Code) {
        this.Cost_Code = cost_Code;
    }

    // ProjectResources
    @OneToMany(mappedBy = "resource", cascade =
            CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    // the mappedBy should be the object used in ProjectResource
    private List<ProjectResource> ProjectResources;

    @Override
    public String toString() {
        return "Resource{" +
                "ResourceId=" + ResourceId +
                ", ResourceName='" + ResourceName + '\'' +
                ", Cost_Code='" + Cost_Code + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resource)) return false;

        Resource resource = (Resource) o;

        if (ResourceName != null ? !ResourceName.equals(resource.ResourceName) : resource.ResourceName != null)
            return false;
        if (Cost_Code != null ? !Cost_Code.equals(resource.Cost_Code) : resource.Cost_Code != null) return false;
        return ProjectResources != null ? ProjectResources.equals(resource.ProjectResources) : resource.ProjectResources == null;
    }

    @Override
    public int hashCode() {
        int result = ResourceId;
        result = 31 * result + (ResourceName != null ? ResourceName.hashCode() : 0);
        result = 31 * result + (Cost_Code != null ? Cost_Code.hashCode() : 0);
        result = 31 * result + (ProjectResources != null ? ProjectResources.hashCode() : 0);
        return result;
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
            projectResource.setResource(this);
        }
    }
    // remove ProjectResource
    public void removeProjectResource(ProjectResource projectResource) {
        if (!ProjectResources.contains(projectResource)) {
            ProjectResources.remove(projectResource);
            projectResource.setResource(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resource)) return false;

        Resource resource = (Resource) o;

        if (ResourceId != resource.ResourceId) return false;
        if (ResourceName != null ? !ResourceName.equals(resource.ResourceName) : resource.ResourceName != null)
            return false;
        if (Cost_Code != null ? !Cost_Code.equals(resource.Cost_Code) : resource.Cost_Code != null) return false;
        return ProjectResources != null ? ProjectResources.equals(resource.ProjectResources) : resource.ProjectResources == null;
    }

    @Override
    public int hashCode() {
        int result = ResourceId;
        result = 31 * result + (ResourceName != null ? ResourceName.hashCode() : 0);
        result = 31 * result + (Cost_Code != null ? Cost_Code.hashCode() : 0);
        result = 31 * result + (ProjectResources != null ? ProjectResources.hashCode() : 0);
        return result;
    }*/
}
