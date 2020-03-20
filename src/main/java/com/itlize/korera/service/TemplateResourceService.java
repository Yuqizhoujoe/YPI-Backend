package com.itlize.korera.service;

import com.itlize.korera.dto.TemplateResourceDTO;
import com.itlize.korera.entity.Template;
import com.itlize.korera.entity.TemplateResource;

import java.util.List;
import java.util.Set;

public interface TemplateResourceService {

    // get all the templateResources
    public List<TemplateResource> getAllTemplateResources();

    // get the templateResources by projectId
    public List<TemplateResourceDTO> getTemplateResource(int projectId);

    // get the templateResources by resourceId
    public List<TemplateResourceDTO> getTemplateResourceByResourceId(int resourceId);

    // add the templateResources
    public TemplateResource addTemplateResource(TemplateResourceDTO templateResourceDTO);

    // add the templateResources
    public List<TemplateResource> addTemplateResources(List<TemplateResourceDTO> templateResourceDTOS);

    // update the templateResources by projectId
}
