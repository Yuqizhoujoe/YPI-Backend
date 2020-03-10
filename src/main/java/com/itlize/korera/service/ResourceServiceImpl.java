package com.itlize.korera.service;

import com.itlize.korera.entity.Resource;
import com.itlize.korera.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    // get Resource by Id
    @Override
    public Resource getResourceById(int id) {
        return resourceRepository.findById(id).get();
    }

    // create resource
    @Override
    public Resource addResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    // add a list of resources
    @Override
    public void addResources(List<Resource> resources) {
        for (Resource r : resources) {
            resourceRepository.save(r);
        }
    }

    // update resource
    @Override
    public void updateResource(Resource resource) {
        resourceRepository.save(resource);
    }

    // delete resource by id
    @Override
    public void deleteResourceById(int id) {
        resourceRepository.deleteById(id);
    }

}
