package com.itlize.korera.service;

import com.itlize.korera.entity.Resource;
import com.itlize.korera.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

    // field injection
    @Autowired
    private ResourceRepository resourceRepository;

    // get all resources
    @Override
    public List<Resource> getAllResources() {
        // create list for resources
        List<Resource> resources = new ArrayList<>();
        resourceRepository.findAll()
                .forEach(resources::add);
        return resources;
    }

    @Override
    public Resource addResource(Resource newResource) {
        resourceRepository.save(newResource);
        return newResource;
    }

    @Override
    public boolean deleteResourceById(Resource newResource) {

        resourceRepository.delete(newResource);
        System.out.println(newResource);
        return true;
    }

    @Override
    public Optional<Resource> getResourceById(int id) {
        Optional<Resource> newResource = null;

        newResource = resourceRepository.findById(id);
        return newResource;
    }

    @Override
    public Resource updateResourceById(Resource newResource) {
        resourceRepository.save(newResource);
        return newResource;
    }

}
