package com.itlize.korera.entity;

import javax.persistence.*;

@Entity
@Table(name = "project_resource")
public class ProjectResource {

    private int ProjectResourceId;
    private int ResourceId;
    private String ResourceName;
    private String Cost_Code;
    private int ProjectId;
    private String ProjectName;

    // ProjectResourceId
    @Id
    @Column(name = "ProjectResourceId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getProjectResourceId() {
        return ProjectResourceId;
    }

    public void setProjectResourceId(int projectResourceId) {
        ProjectResourceId = projectResourceId;
    }

    // ResourceId
    @Column(name = "ResourceId", nullable = false)
    public int getResourceId() {
        return ResourceId;
    }

    public void setResourceId(int resourceId) {
        ResourceId = resourceId;
    }

    // ResourceName
    @Column(name = "ResourceName", nullable = false)
    public String getResourceName() {
        return ResourceName;
    }

    public void setResourceName(String resourceName) {
        ResourceName = resourceName;
    }

    // Cost_Code
    @Column(name = "Cost_Code", nullable = false)
    public String getCost_Code() {
        return Cost_Code;
    }

    public void setCost_Code(String cost_Code) {
        Cost_Code = cost_Code;
    }

    // ProjectId
    @Column(name = "ProjectId", nullable = false)
    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    // ProjectName
    @Column(name = "ProjectName", nullable = false)
    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }
}
