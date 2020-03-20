package com.itlize.korera.service;

import com.itlize.korera.dto.TemplateResourceDTO;
import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.Resource;
import com.itlize.korera.entity.Template;
import com.itlize.korera.entity.TemplateResource;
import com.itlize.korera.repository.ProjectRepository;
import com.itlize.korera.repository.ResourceRepository;
import com.itlize.korera.repository.TemplateRepository;
import com.itlize.korera.repository.TemplateResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TemplateResourceServiceImpl implements TemplateResourceService {

    @Autowired
    private TemplateResourceRepository templateResourceRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private TemplateRepository templateRepository;
    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public List<TemplateResource> getAllTemplateResources() {
        return templateResourceRepository.findAll();
    }

    @Override
    public List<TemplateResourceDTO> getTemplateResource(int projectId) {
        Set<TemplateResource> templateResources = templateResourceRepository.
                                    findTemplateResourceByProjectId(projectId);
        // create result list
        List<TemplateResourceDTO> results = new ArrayList<>();
        for (TemplateResource templateResource : templateResources) {
            // create TemplateResourceDTO
            TemplateResourceDTO templateResourceDTO = new TemplateResourceDTO();
            // set the templateResourceId
            templateResourceDTO.setTemplateResourceId(templateResource.getTemplateResourceId());
            // set the templateId
            templateResourceDTO.setTemplateId(templateResource.getTemplate().getTemplateId());
            // set the templateName
            templateResourceDTO.setTemplateName(templateResource.getTemplate().getTemplateName());
            // set the templateType
            templateResourceDTO.setTemplateType(templateResource.getTemplate().getTemplateType());
            // set the resourceId
            templateResourceDTO.setResourceId(templateResource.getResource().getResourceId());
            // set the templateResourceValue
            templateResourceDTO.setTemplateResourceValue(templateResource.getTemplateResourceValue());
            // set the templateResourceText
            templateResourceDTO.setTemplateResourceText(templateResource.getTemplateResourceText());
            // add
            results.add(templateResourceDTO);
            // sort
            Collections.sort(results);
        }
        return results;
    }

    @Override
    public List<TemplateResourceDTO> getTemplateResourceByResourceId(int resourceId) {
        Set<TemplateResource> templateResources = templateResourceRepository.
                findTemplateResourceByResourceId(resourceId);
        // create result list
        List<TemplateResourceDTO> results = new ArrayList<>();
        for (TemplateResource templateResource : templateResources) {
            // create TemplateResourceDTO
            TemplateResourceDTO templateResourceDTO = new TemplateResourceDTO();
            // set the templateResourceId
            templateResourceDTO.setTemplateResourceId(templateResource.getTemplateResourceId());
            // set the templateId
            templateResourceDTO.setTemplateId(templateResource.getTemplate().getTemplateId());
            // set the templateName
            templateResourceDTO.setTemplateName(templateResource.getTemplate().getTemplateName());
            // set the templateType
            templateResourceDTO.setTemplateType(templateResource.getTemplate().getTemplateType());
            // set the resourceId
            templateResourceDTO.setResourceId(templateResource.getResource().getResourceId());
            // set the templateResourceValue
            templateResourceDTO.setTemplateResourceValue(templateResource.getTemplateResourceValue());
            // set the templateResourceText
            templateResourceDTO.setTemplateResourceText(templateResource.getTemplateResourceText());
            // add
            results.add(templateResourceDTO);
        }
        Collections.sort(results);
        System.out.println(results);
        return results;
    }

    @Override
    public TemplateResource addTemplateResource(TemplateResourceDTO templateResourceDTO) {
        System.out.println("addTemplateResource");
        // get the template by templateId
        Template template = templateRepository.findById(templateResourceDTO.getTemplateId()).get();
        // get the resource by resourceId
        Resource resource = resourceRepository.findById(templateResourceDTO.getResourceId()).get();
        // find the newest templateResourceId
        int templateResourceId = templateResourceRepository.
                findTheBiggestTemplateResourceId().get(0).getTemplateResourceId();
        // create new TemplateResource
        TemplateResource templateResource = new TemplateResource();
        //set resource
        templateResource.setResource(resource);
        // set template
        templateResource.setTemplate(template);
        // set templateResourceId
        templateResource.setTemplateResourceId(templateResourceId+1);
        // set the templateResourceValue
        templateResource.setTemplateResourceValue(templateResourceDTO.getTemplateResourceValue());
        // set the templateResourceText
        templateResource.setTemplateResourceText(templateResourceDTO.getTemplateResourceText());
        // save
        TemplateResource saved = templateResourceRepository.save(templateResource);
        return saved;
    }

    @Override
    public List<TemplateResource> addTemplateResources(List<TemplateResourceDTO> templateResourceDTOS) {
        // create empty list TemplateResource
        List<TemplateResource> results = new ArrayList<>();
        // loop through templateResourceDTOS
        for (TemplateResourceDTO templateResourceDTO : templateResourceDTOS) {
            // get the template by templateId
            Template template = templateRepository.findById(templateResourceDTO.getTemplateId()).get();
            // get the resource by resourceId
            Resource resource = resourceRepository.findById(templateResourceDTO.getResourceId()).get();
            // find the newest templateResourceId
            int templateResourceId = templateResourceRepository.
                    findTheBiggestTemplateResourceId().get(0).getTemplateResourceId();
            // create new TemplateResource
            TemplateResource templateResource = new TemplateResource();
            //set resource
            templateResource.setResource(resource);
            // set template
            templateResource.setTemplate(template);
            // set templateResourceId
            templateResource.setTemplateResourceId(templateResourceId+1);
            // set the templateResourceValue
            templateResource.setTemplateResourceValue(templateResourceDTO.getTemplateResourceValue());
            // set the templateResourceText
            templateResource.setTemplateResourceText(templateResourceDTO.getTemplateResourceText());
            // save
            TemplateResource saved = templateResourceRepository.save(templateResource);
            // add
            results.add(saved);
            // sort
            Collections.sort(results);
        }
        return results;
    }


}
