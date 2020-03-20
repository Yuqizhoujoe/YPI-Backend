package com.itlize.korera.service;

import com.itlize.korera.entity.Template;

import java.util.List;

public interface TemplateService {

    // get all templates
    public List<Template> getAllTemplates();

    // get all templates by projectId
    public List<Template> getAllTemplatesByProjectId(int projectId);

    // add Template by projectId
    public Template addTemplate(int projectId, Template t);

    // add Templates by projectId
    public List<Template> addTemplates(int projectId, List<Template> templates);

    // update Template by templateId
    public Template updateTemplate(Template template, int id);

    // delete Template by templateId
    public boolean deleteTemplate(int templateId);


}
