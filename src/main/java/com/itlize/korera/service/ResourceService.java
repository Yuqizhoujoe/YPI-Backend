package com.itlize.korera.service;

import com.itlize.korera.entity.Resource;

import java.util.List;
import java.util.Optional;

public interface ResourceService {
    // get all resources from Resource Table
    public List<Resource> getAllResources();

    public Resource addResource(Resource newResource);

    public boolean deleteResourceById(Resource newResource);

    public Optional<Resource> getResourceById(int id);

    public Resource updateResourceById(Resource resource);

}
