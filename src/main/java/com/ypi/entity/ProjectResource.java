package com.ypi.entity;

import javax.persistence.*;

@Entity
@Table(name = "project_resource")
public class ProjectResource {

    private int ResourceId;
    private String ResourceName;
    private String Cost_Code;

    public ProjectResource() {
    }

    public ProjectResource(String ResourceName, String Cost_Code){
        this.ResourceName = ResourceName;
        this.Cost_Code = Cost_Code;
    }

    // getter and setter for ResourceId
    @Id
    @Column(name = "ResourceId", unique = true, nullable = false)
    @GeneratedValue(generator = "increment")
    public int getResourceId() {
        return ResourceId;
    }

    public void setResourceId(int resourceId) {
        ResourceId = resourceId;
    }

    // getter and setter for ResourceName
    @Column(name = "ResourceName", nullable = false)
    public String getResourceName() {
        return ResourceName;
    }

    public void setResourceName(String resourceName) {
        ResourceName = resourceName;
    }

    // getter and setter for Cost_Code
    @Column(name = "Cost_Code", nullable = false)
    public String getCost_Code() {
        return Cost_Code;
    }

    public void setCost_Code(String cost_Code) {
        Cost_Code = cost_Code;
    }

    // getter and setter for extraCol

    // ToString()
    @Override
    public String toString() {
        return "Resource{" +
                "ResourceId=" + ResourceId +
                ", ResourceName='" + ResourceName + '\'' +
                ", Cost_Code='" + Cost_Code + '\'' +
                '}';
    }
}
