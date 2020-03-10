package com.itlize.korera.controller;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.ProjectResource;
import com.itlize.korera.entity.Resource;
import com.itlize.korera.service.ProjectResourceService;
import com.itlize.korera.service.ProjectService;
import com.itlize.korera.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProjectResourceController {

    // field injection - projectResourceService
    @Autowired
    private ProjectResourceService projectResourceService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ResourceService resourceService;

    // get all projectResources
    @GetMapping("/project/projectResource")
    public List<ProjectResource> getAllProjectResources() {
        return projectResourceService.getAllProjectResources();
    }

    // get the ProjectResources by ProjectId
    @GetMapping("/project/{projectId}/projectResource")
    public List<ProjectResource> getProjectResourceByProjectId(@PathVariable("projectId") int id){
        return projectResourceService.getProjectResourceByProjectId(id);
    }

    // get ProjectResource by ProjectResourceId
    @GetMapping("/project/{projectId}/projectResource/{projectResourceId}")
    public ProjectResource getProjectResourceById(
            @PathVariable("projectId") int projectId,
            @PathVariable("projectResourceId") int projectResourceId) {
        return projectResourceService.getProjectResourceByProjectResourceId(projectId, projectResourceId);
    }

    // add ProjectResource for project
    @PostMapping("/project/{projectId}/resource/{resourceId}")
    public void addProjectResource(@PathVariable int projectId,
                                   @PathVariable int resourceId) {
        projectResourceService.addProjectResource(projectId, resourceId);
    }

    // add ProjectResources for project
    @PostMapping("/project/{projectId}/resources")
    public void addProjectResources(@RequestBody List<Resource> resources,
                                    @PathVariable int projectId)
    {
        projectResourceService.addProjectResources(projectId, resources);
    }

    // update ProjectResource
    @PutMapping("/project/{projectId}/resource/{resourceId}/projectResource/{projectResourceId}")
    public void updateProjectResource(@PathVariable int projectId,
                                      @PathVariable int resourceId,
                                      @PathVariable int projectResourceId){
        projectResourceService.updateProjectResource(projectId, resourceId, projectResourceId);
    }

    // delete projectResource by projectResourceId
    @DeleteMapping("/projectResource/{projectResourceId}")
    public void deleteProjectResource(@PathVariable int projectResourceId) {
        projectResourceService.deleteProjectResource(projectResourceId);
    }

    // delete resource from the project
    @DeleteMapping("/project/{projectId}/resource/{resourceId}")
    public void deleteResourceFromProject(@PathVariable int projectId,
                                          @PathVariable int resourceId) {
        projectResourceService.deleteResourceFromProject(projectId, resourceId);
    }
}
