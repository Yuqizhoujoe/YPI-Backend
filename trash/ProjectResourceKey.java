package com.itlize.korera.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;

@Embeddable
public class ProjectResourceKey implements Serializable {

    @Column(name = "ResourceId")
    private int ResourceId;

    @Column(name = "ProjectId")
    private int ProjectId;

    public ProjectResourceKey() {
    }

    public ProjectResourceKey(int ResourceId, int ProjectId) {
        this.ResourceId = ResourceId;
        this.ProjectId = ProjectId;
    }

    public int getResourceId() {
        return ResourceId;
    }

    public int getProjectId() {
        return ProjectId;
    }

}
