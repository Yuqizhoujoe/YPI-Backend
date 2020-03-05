package com.itlize.korera.entity;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {

    private int ProjectId;
    private String ProjectName;

    // ProjectId
    @Id
    @Column(name = "ProjectId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
