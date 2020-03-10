package com.itlize.korera.service;

import com.itlize.korera.entity.Resource;
import com.itlize.korera.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    // get all resources
    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
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
