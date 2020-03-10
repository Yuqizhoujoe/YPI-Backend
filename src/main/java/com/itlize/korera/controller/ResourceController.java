package com.itlize.korera.controller;

import com.itlize.korera.entity.Resource;
import com.itlize.korera.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResourceController {

    // field injection - resourceService
    @Autowired
    private ResourceService resourceService;

    // get al resources
    @GetMapping("/resources")
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

    // add resource
    @PostMapping("/resource")
    public Resource createResource(@RequestBody Resource resource) {
        return resourceService.addResource(resource);
    }

    // add a list of resources
    @PostMapping("/resources")
    public void addResources(@RequestBody List<Resource> resources) {
        resourceService.addResources(resources);
    }

    // update resource by resourceId
    @PutMapping("/resources/{id}")
    public void updateResource(@RequestBody Resource resource) {
        resourceService.updateResource(resource);
    }

    // delete resource by resourceId
    @DeleteMapping("/resources/{id}")
    public void deleteResourceById(@PathVariable int id) {
        resourceService.deleteResourceById(id);
    }
}
