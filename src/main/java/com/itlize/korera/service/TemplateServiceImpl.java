package com.itlize.korera.service;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.Template;
import com.itlize.korera.repository.ProjectRepository;
import com.itlize.korera.repository.ProjectResourceRepository;
import com.itlize.korera.repository.ResourceRepository;
import com.itlize.korera.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.font.TextMeasurer;
import java.util.ArrayList;
import java.util.List;

@Service("templateService")
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateRepository templateRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Template> getAllTemplates() {
        return templateRepository.findAll();
    }

    @Override
    public List<Template> getAllTemplatesByProjectId(int projectId) {
        List<Template> resultList = this.templateRepository.findByProjectId(projectId);
        return resultList;
    }

    @Override
    public Template addTemplate(int projectId, Template t) {
        System.out.println("add template: ");
        // get project by projectId
        Project project = projectRepository.findById(projectId).get();
        Template firstTemplate = templateRepository.findTheBiggestTemplateId().get(0);
        // set the id
        t.setTemplateId(firstTemplate.getTemplateId()+1);
        // set the project
        t.setProject(project);
        System.out.println(t.toString());
        // save the template
        Template saved = templateRepository.save(t);
        System.out.println(saved.toString());
        return saved;
    }

    @Override
    public List<Template> addTemplates(int projectId, List<Template> templates) {
        System.out.println("add templates: ");
        Project project = projectRepository.findById(projectId).get();
        List<Template> resultList = new ArrayList<>();
        for (Template t : templates) {
            // get the biggest templateId
            int templateId = templateRepository.findTheBiggestTemplateId().get(0).getTemplateId();
            // set the id
            t.setTemplateId(templateId+1);
            // set the project
            t.setProject(project);
            System.out.println(t.toString());
            //save the template
            Template saved = templateRepository.save(t);
            // add the template to the resultList
            resultList.add(saved);
        }
        templateRepository.flush();
        return resultList;
    }

    @Override
    public Template updateTemplate(Template template, int id) {
        // get the template by id
        Template t = templateRepository.findById(id).get();
        // set the template name
        t.setTemplateName(template.getTemplateName());
        // set the template type
        t.setTemplateType(template.getTemplateType());
        // set the template formula
        t.setTemplateFormula(template.getTemplateFormula());
        // save
        Template saved = templateRepository.save(t);
        return saved;
    }

    @Override
    public boolean deleteTemplate(int templateId) {
        templateRepository.deleteById(templateId);
        return true;
    }
}
