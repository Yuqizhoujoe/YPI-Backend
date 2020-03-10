package com.itlize.korera.entity;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {
    // ProjectId
    @Id
    @Column(name = "ProjectId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProjectId;
    // ProjectName
    @Column(name = "ProjectName", nullable = false)
    private String ProjectName;

    public Project(String ProjectName) {
        this.ProjectId = ProjectId;
    }

    public Project() {
    }

    public Project(int ProjectId) {
        this.ProjectId = ProjectId;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }

    @Override
    public String toString() {
        return "Project{" +
                "ProjectId=" + ProjectId +
                ", ProjectName='" + ProjectName + '\'' +
                '}';
    }
}
