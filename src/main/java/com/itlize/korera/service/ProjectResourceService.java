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

    // get the projectResource by ProjectResourceId
    public ProjectResource getProjectResourceByProjectResourceId(int projectResourceId);

    // get ProjectResource by ProjectResourceId and ProjectId
    public ProjectResource getProjectResourceByProjectResourceAndProjectId(int projectResourceId, int projectId);

    // get ProjectResource by ProjectId
    public List<ProjectResource> getProjectResourceByProjectId(int projectId);

    // add projectResource
    public ProjectResource addProjectResource(int projectId, int resourceId);

    // add projectResources
    public List<ProjectResource> addProjectResources(int projectId, List<Resource> resources);

    // update projectResource
    public boolean updateProjectResource(int projectResourceId, int projectId, int resourceId);

    // delete projectResource
    public boolean deleteProjectResource(int projectResourceId);

    // delete resource from the project
    public boolean deleteResourceFromProject(int projectId, int resourceId);

}
