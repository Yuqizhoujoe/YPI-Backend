package com.itlize.korera.service;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.ProjectResource;
import com.itlize.korera.entity.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProjectResourceService {

    // get all the projectResources
    public List<ProjectResource> getAllProjectResources();

    // get ProjectResource by ProjectResourceId
    public ProjectResource getProjectResourceByProjectResourceId(int projectResourceId, int projectId);

    // get ProjectResource by ProjectId
    public List<ProjectResource> getProjectResourceByProjectId(int projectId);

    // add projectResource
    public void addProjectResource(int projectId, int resourceId);

    // add projectResources
    public void addProjectResources(int projectId, List<Resource> resources);

    // update projectResource
    public void updateProjectResource(int projectResourceId, int projectId, int resourceId);

    // delete projectResource
    public void deleteProjectResource(int projectResourceId);

    // delete resource from the project
    public void deleteResourceFromProject(int projectId, int resourceId);

}
