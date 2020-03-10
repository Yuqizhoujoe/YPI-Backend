package com.itlize.korera.service;

import com.itlize.korera.entity.Resource;

import java.util.List;

public interface ResourceService {
    // get all resources from Resource Table
    public List<Resource> getAllResources();

    // get resource by id
    public Resource getResourceById(int id);

    // Create new resource
    public Resource addResource(Resource resource);

    // add a list of resources
    public void addResources(List<Resource> resources);

    // update resource
    public void updateResource(Resource resource);

    // delete resource
    public void deleteResourceById(int id);
}
