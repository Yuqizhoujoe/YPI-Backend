package com.itlize.korera.controller;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.ProjectResource;
import com.itlize.korera.entity.Resource;
import com.itlize.korera.service.ProjectResourceService;
import com.itlize.korera.service.ProjectService;
import com.itlize.korera.service.ResourceService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProjectResourceController {

    // field injection - projectResourceService
    @Autowired
    private ProjectResourceService projectResourceService;

    // get all projectResources
    @GetMapping(value = "/project/projectResource", produces = "application/json")
    public List<ProjectResource> getAllProjectResources() {
        return projectResourceService.getAllProjectResources();
    }

    // get projectResource by projectResourceId
    @GetMapping(value = "/projectResource/{projectResourceId}", produces = "application/json")
    public ProjectResource getProjectResourceByProjectResourceId(@PathVariable @NotNull int projectResourceId) {
        return projectResourceService.getProjectResourceByProjectResourceId(projectResourceId);
    }

    // get the ProjectResources by ProjectId
    @GetMapping(value = "/project/{projectId}/projectResource", produces = "application/json")
    public List<ProjectResource> getProjectResourceByProjectId(@PathVariable("projectId")
                                                                   @NotNull int id){
        return projectResourceService.getProjectResourceByProjectId(id);
    }

    // get ProjectResource by ProjectResourceId and ProjectId
    @GetMapping(value = "/project/{projectId}/projectResource/{projectResourceId}",
            produces = "application/json")
    public ProjectResource getProjectResourceByProjectResourceAndProjectId(
            @PathVariable("projectId") @NotNull int projectId,
            @PathVariable("projectResourceId") @NotNull int projectResourceId) {
        return projectResourceService.getProjectResourceByProjectResourceAndProjectId(projectId, projectResourceId);
    }

    // add ProjectResource for project
    @PostMapping(value = "/project/{projectId}/resource/{resourceId}",
                produces = "application/json")
    public ProjectResource addProjectResource(@PathVariable int projectId,
                                   @PathVariable int resourceId) {
        return projectResourceService.addProjectResource(projectId, resourceId);
    }

    // add ProjectResources for project
    @PostMapping("/project/{projectId}/resources")
    public List<ProjectResource> addProjectResources(@RequestBody List<Resource> resources,
                                    @PathVariable int projectId)
    {
        return projectResourceService.addProjectResources(projectId, resources);
    }

    // update ProjectResource
    @PutMapping(value = "/project/{projectId}/resource/{resourceId}/projectResource/{projectResourceId}",
    produces = "application/json")
    public String updateProjectResource(@PathVariable int projectId,
                                      @PathVariable int resourceId,
                                      @PathVariable int projectResourceId){
        boolean isUpdate = false;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "ProjectResourceController");
        try {
            isUpdate = projectResourceService.
                    updateProjectResource(projectResourceId, projectId, resourceId);
        } catch (Exception ex) {
            System.out.println("ProjectResource not found to update " + ex.getMessage());
            return "Error updating the ProjectResource: " + ex.toString();
        }

        if (isUpdate) {
            return "ProjectResource successfully updated!";
        }
        return "Error! ProjectResource updated!";
    }

    // delete projectResource by projectResourceId
    @DeleteMapping("/projectResource/{projectResourceId}")
    public String deleteProjectResource(@PathVariable int projectResourceId) {
        boolean isDelete = false;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "ProjectResourceController");
        try {
            isDelete = projectResourceService.
                    deleteProjectResource(projectResourceId);
        } catch (Exception ex) {
            System.out.println("ProjectResource not found to delete " + ex.getMessage());
            return "Error deleting the ProjectResource: " + ex.toString();
        }

        if (isDelete) {
            return "ProjectResource successfully deleted!";
        }
        return "Error! ProjectResource deleted!";
    }

    // delete resource from the project
    @DeleteMapping("/project/{projectId}/resource/{resourceId}")
    public String deleteResourceFromProject(@PathVariable("projectId") int projectId,
                                          @PathVariable("resourceId") int resourceId) {
        boolean isDelete = false;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "ProjectResourceController");
        try {
            isDelete = projectResourceService.
                    deleteResourceFromProject(projectId, resourceId);
        } catch (Exception ex) {
            System.out.println("ProjectResource not found to delete " + ex.getMessage());
            return "Error deleting the ProjectResource: " + ex.toString();
        }

        if (isDelete) {
            return "ProjectResource successfully deleted!";
        }
        return "Error! ProjectResource deleted!";
    }
}
