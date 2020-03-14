package com.itlize.korera.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.util.List;

                  ///////////////////////////////////////////////////////////////////////
                 // RESOURCE TABLE ENTITY: MAIN DATA, RELATIONSHIP-> PROJECT:RESOURCE //
                ///////////////////////////////////////////////////////////////////////

@Entity
@Table(name = "resources")
public class Resource {

      ////////////////////////////////////////////////
     // FIELDS(ID,NAME,COST:CODE,PROJECT:RESOURCE) //
    ////////////////////////////////////////////////

    @Id
    @Column(name = "ResourceId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ResourceId;

    @Column(name = "resourceName", unique = true, nullable = false)
    private String ResourceName;

    @Column(name = "Cost_Code", unique = true, nullable = false)
    private String Cost_Code;

    @OneToMany(mappedBy = "resource", cascade = {
            CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ProjectResource> ProjectResources;


      /////////////////////////////////////
     //// CONSTRUCTORS(NAME,NONE,ID) /////
    /////////////////////////////////////

    public Resource() {
    }

    public Resource(int ResourceId) {

        this.ResourceId = ResourceId;
    }

    public Resource(String ResourceName, String Cost_Code){
        this.ResourceName = ResourceName;
        this.Cost_Code = Cost_Code;
    }

      ////////////////////////////////////////////
     // GETTERS AND SETTERS (ID,NAME,CC,PR(S)) //
    ////////////////////////////////////////////

    public int getResourceId() {
        return this.ResourceId;
    }
    public void setResourceId(int resourceId) {
        ResourceId = resourceId;
    }

    public String getResourceName() {
        return this.ResourceName;
    }
    public void setResourceName(String resourceName) {
        this.ResourceName = resourceName;
    }

    public String getCost_Code() {
        return this.Cost_Code;
    }
    public void setCost_Code(String cost_Code) {
        this.Cost_Code = cost_Code;
    }


      /////////////////////////////////////
     ////// TO-STRING (NAME,ID) //////////
    /////////////////////////////////////

    @Override
    public String toString() {
        return "Resource{" +
                "ResourceId=" + ResourceId +
                ", ResourceName='" + ResourceName + '\'' +
                ", Cost_Code='" + Cost_Code + '\'' + '}';
    }


      //////////////////////////////////////
     // EQUALS METHOD(PROJECT RESOURCE) ///
    //////////////////////////////////////


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

}
