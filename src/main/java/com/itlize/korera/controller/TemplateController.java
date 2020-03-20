package com.itlize.korera.controller;

import com.itlize.korera.entity.Template;
import com.itlize.korera.service.TemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemplateController {

    /////////////////////////////////////
    //// FIELDS(TEMPLATE:SERVICE) ///////
    /////////////////////////////////////
    @Autowired
    private TemplateService templateService;

    ////////////////////////////////////////////
    //// GET:ALL TEMPLATES(LIST)(NO-AUTH)///////
    ////////////////////////////////////////////

    @GetMapping(value = "/templates", produces = "application/json")
    @ResponseBody
    public List<Template> getAllTemplates() {
        return this.templateService.getAllTemplates();
    }

    ///////////////////////////////////////////
    //// GET:TEMPLATES BY PROJECTID: AUTH /////
    ///////////////////////////////////////////

    @GetMapping(value = "/templates/{projectId}", produces = "application/json")
    @ResponseBody
    public List<Template> getAllTemplatesByProjectId(@PathVariable int projectId) {
        return this.templateService.getAllTemplatesByProjectId(projectId);
    }

    ///////////////////////////////////////////
    //// POST:POST A TEMPLATE: AUTH /////
    ///////////////////////////////////////////

    @PostMapping(value = "/addTemplate/{projectId}")
    public Template addTemplate(@PathVariable int projectId, @RequestBody Template t) {
        return this.templateService.addTemplate(projectId, t);
    }

    ///////////////////////////////////////////
    //// POST:POST TEMPLATES: AUTH //////////
    ///////////////////////////////////////////

    @PostMapping(value = "/addTemplates/{projectId}", produces = "application/json")
    @ResponseBody
    public List<Template> addTemplates(@PathVariable int projectId, @RequestBody List<Template> templates) {
        return this.templateService.addTemplates(projectId, templates);
    }

    ///////////////////////////////////////////
    //// PUT:PUT TEMPLATE: AUTH //////////
    ///////////////////////////////////////////

    @PutMapping(value = "/updateTemplate/{id}", produces = "application/json")
    @ResponseBody
    public Template updateTemplate(@RequestBody Template template, @PathVariable int id) {
        return this.templateService.updateTemplate(template, id);
    }

    ///////////////////////////////////////////
    //// DELETE:DELETE TEMPLATE: AUTH //////////
    ///////////////////////////////////////////

    @DeleteMapping(value = "/deleteTemplate/{templateId}", produces = "application/json")
    @ResponseBody
    public boolean deleteTemplate(@PathVariable int templateId) {
        return this.templateService.deleteTemplate(templateId);
    }

}
