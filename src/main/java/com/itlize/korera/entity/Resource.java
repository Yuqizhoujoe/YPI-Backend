package com.itlize.korera.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "resources")
public class Resource {


    @Id
    @Column(name = "ResourceId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ResourceId;
    @Column(name = "resourceName", nullable = false)
    private String ResourceName;
    @Column(name = "Cost_Code", nullable = false)
    private String Cost_Code;



    public Resource() {
    }

    public Resource(int ResourceId) {
        this.ResourceId = ResourceId;
    }

    public Resource(String ResourceName, String Cost_Code){
        this.ResourceName = ResourceName;
        this.Cost_Code = Cost_Code;
    }

    // getter and setter for ResourceId

    public int getResourceId() {
        return ResourceId;
    }

    public void setResourceId(int resourceId) {
        ResourceId = resourceId;
    }

    // getter and setter for ResourceName

    public String getResourceName() {
        return ResourceName;
    }

    public void setResourceName(String resourceName) {
        ResourceName = resourceName;
    }

    // getter and setter for Cost_Code

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
