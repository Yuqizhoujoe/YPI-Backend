package com.itlize.korera.service;

import com.itlize.korera.entity.Resource;
import com.itlize.korera.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    // get all resources
    @Override
    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

}
