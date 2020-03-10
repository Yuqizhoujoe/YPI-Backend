package com.itlize.korera.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.itlize.korera.service.ProjectResourceService;
import com.itlize.korera.service.ProjectResourceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resources;
import javax.persistence.*;
import java.util.*;


                          //////////////////////////////////////////////////////////////////////////
                         // PROJECT TABLE ENTITY: PROJECT DATA , RELATIONSHIP-> PROJECT:RESOURCE //
                        //////////////////////////////////////////////////////////////////////////

@Entity
@Table(name = "projects")
public class Project {

      ///////////////////////////////////////
     // FIELDS(ID,NAME,PROJECT:RESOURCES) //
    ///////////////////////////////////////

    @Id
    @Column(name = "ProjectId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProjectId;


    @Column(name = "ProjectName", nullable = false)
    private String ProjectName;

    @OneToMany(mappedBy = "project", cascade = {
            CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ProjectResource> ProjectResources;


      //////////////////////////////////////
     // CONSTRUCTORS(NAME,NONE,ID) ////////
    //////////////////////////////////////

    public Project() {
    }

    public Project(String ProjectName) {
       this.ProjectName = ProjectName;
    }

    public Project(int ProjectId) {
        this.ProjectId = ProjectId;
    }

      /////////////////////////////////////////
     // GETTERS AND SETTERS (ID,NAME,PR(S)) //
    /////////////////////////////////////////


    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }
    public int getProjectId() {
        return ProjectId;
    }


    public String getProjectName() {

        return this.ProjectName;
    }
    public void setProjectName(String projectName) {

        this.ProjectName = projectName;
    }

      //////////////////////////////////////
     /////// TO-STRING (NAME,ID) //////////
    //////////////////////////////////////

    @Override
    public String toString() {
        return "Project{" +
                "ProjectId=" + ProjectId +
                ", ProjectName='" + ProjectName + '\'' + '}';
    }

}
