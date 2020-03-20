package com.itlize.korera.controller;

import com.itlize.korera.dto.TemplateResourceDTO;
import com.itlize.korera.entity.Template;
import com.itlize.korera.entity.TemplateResource;
import com.itlize.korera.service.TemplateResourceService;
import com.itlize.korera.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemplateResourceController {

    /////////////////////////////////////
    //// FIELDS(TEMPLATERESOURCE:SERVICE) ///////
    /////////////////////////////////////
    @Autowired
    private TemplateResourceService templateResourceService;

    ////////////////////////////////////////////
    //// GET:ALL TEMPLATERESOURCE(LIST)(NO-AUTH)///////
    ////////////////////////////////////////////

    @GetMapping(value = "/templateResources", produces = "application/json")
    @ResponseBody
    public List<TemplateResource> getAllTemplateResources() {
        return this.templateResourceService.getAllTemplateResources();
    }

    ///////////////////////////////////////////
    //// GET:TEMPLATERESOURCES BY PROJECTID: AUTH /////
    ///////////////////////////////////////////

    @GetMapping(value = "/templateResources/project/{projectId}",
            produces = "application/json")
    @ResponseBody
    public List<TemplateResourceDTO> getAllTemplateResourcesByProjectId(@PathVariable int projectId) {
        return this.templateResourceService.getTemplateResource(projectId);
    }

    ///////////////////////////////////////////
    //// GET:TEMPLATERESOURCES BY RESOURCEID: AUTH /////
    ///////////////////////////////////////////

    @GetMapping(value = "/templateResources/resource/{resourceId}",
            produces = "application/json")
    @ResponseBody
    public List<TemplateResourceDTO> getTemplateResourceByResourceId(@PathVariable int resourceId) {
        return this.templateResourceService.getTemplateResourceByResourceId(resourceId);
    }

    ///////////////////////////////////////////
    //// POST:POST TEMPLATERESOURCE: AUTH /////
    ///////////////////////////////////////////

    @PostMapping(value = "/addTemplateResource")
    @ResponseBody
    public TemplateResource addTemplateResource(@RequestBody TemplateResourceDTO templateResourceDTO) {
        return this.templateResourceService.addTemplateResource(templateResourceDTO);
    }

    ///////////////////////////////////////////
    //// POST:POST TEMPLATERESOURCES: AUTH /////
    ///////////////////////////////////////////
    @PostMapping(value = "/addTemplateResources")
    @ResponseBody
    public List<TemplateResource> addTemplateResource(@RequestBody List<TemplateResourceDTO> templateResourceDTOS) {
        return this.templateResourceService.addTemplateResources(templateResourceDTOS);
    }

}
