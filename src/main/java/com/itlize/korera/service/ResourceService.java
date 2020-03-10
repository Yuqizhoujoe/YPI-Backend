package com.itlize.korera.service;

import com.itlize.korera.entity.Resource;

import java.util.List;
import java.util.Optional;

public interface ResourceService {
    // get all resources from Resource Table
    public List<Resource> getAllResources();

    // add resource
    public Resource addResource(Resource newResource);

    // delete resource
    public boolean deleteResourceById(Resource newResource);

    // get resource
    public Optional<Resource> getResourceById(int id);

    // update resource
    public Resource updateResourceById(Resource resource);

}
