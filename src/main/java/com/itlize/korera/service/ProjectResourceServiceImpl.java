package com.itlize.korera.service;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.ProjectResource;
import com.itlize.korera.entity.Resource;
import com.itlize.korera.repository.ProjectRepository;
import com.itlize.korera.repository.ProjectResourceRepository;
import com.itlize.korera.repository.ResourceRepository;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.*;

@Service("projectResourceService")
@Transactional
public class ProjectResourceServiceImpl implements ProjectResourceService {

    // field injection for ProjectResourceService
    @Autowired
    private ProjectResourceRepository projectResourceRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ResourceRepository resourceRepository;

    // get all the project_resources
    @Override
    public List<ProjectResource> getAllProjectResources() {
        return projectResourceRepository.findAll();
    }

    // get the projectResource by ProjectResourceId
    @Override
    public ProjectResource getProjectResourceByProjectResourceId(int projectResourceId) {
        return projectResourceRepository.findById(projectResourceId).get();
    }

    // get the ProjectResource by projectResourceId and ProjectId
    @Override
    public ProjectResource getProjectResourceByProjectResourceAndProjectId(int projectResourceId, int projectId) {
        return projectResourceRepository.findProjectResourceByProjectResourceId(projectResourceId, projectId);
    }

    // get the list of ProjectResource by projectId
    @Override
    public List<ProjectResource> getProjectResourceByProjectId(int projectId) {
        return projectResourceRepository.findByProjectId(projectId);
    }

    // add projectResource
    @Override
    public ProjectResource addProjectResource(int projectId, int resourceId) {
        // get the project by projectId
        Project project = projectRepository.findById(projectId).get();
        // get the resource by resourceId
        Resource resource = resourceRepository.findById(resourceId).get();
        // create new projectResource
        ProjectResource projectResource = new ProjectResource();
        // set resource
        projectResource.setResource(resource);
        // set project
        projectResource.setProject(project);
        // save the projectResource
        ProjectResource saved = projectResourceRepository.save(projectResource);
        projectResourceRepository.flush();
        return saved;
    }

    // add projectResources
    @Override
    public List<ProjectResource> addProjectResources(int projectId, List<Resource> resources) {
        // get the project by projectId
        Project p = projectRepository.findById(projectId).get();
        // create a List of ProjectResource
        List<ProjectResource> projectResourceList = new ArrayList<>();
        // get each resource in the resources
        for (Resource resource : resources) {
            // find all resources in the DB
            List<Resource> resourceList = resourceRepository.findAll();
            // loop through the resourceList
            for (Resource resourceItem : resourceList) {
                // if the resourceItem equal to resource
                if (resourceItem.getCost_Code().equals(resource.getCost_Code())) {
                    // create new projectResource
                    ProjectResource pr = new ProjectResource();
                    // set project
                    pr.setProject(p);
                    // set resource
                    pr.setResource(resourceItem);
                    // save the projectResource
                    ProjectResource saved = projectResourceRepository.save(pr);
                    projectResourceRepository.flush();
                    // add the projectResource added into projectResource List
                    projectResourceList.add(saved);
                }
            }
        }
        return projectResourceList;
    }

    // update projectResource
    @Override
    public boolean updateProjectResource(int projectResourceId, int projectId, int resourceId) {
        // get the project by projectId
        Project project = projectRepository.findById(projectId).get();
        // get the resource by resourceId
        Resource resource = resourceRepository.findById(resourceId).get();
        // get the projectResource by projectResourceId
        ProjectResource pr = projectResourceRepository.
                findById(projectResourceId).get();
        // set resource
        pr.setResource(resource);
        // set project
        pr.setProject(project);
        // save the projectResource
        ProjectResource saved = projectResourceRepository.save(pr);
        projectResourceRepository.flush();
        // print the saved projectResource
        System.out.println(saved.toString());
        return true;
    }

    // delete projectResource by projectResourceId
    @Override
    public boolean deleteProjectResource(int projectResourceId) {
        System.out.println("execute function deleteProjectResource");
        projectResourceRepository.deleteById(projectResourceId);
        projectResourceRepository.flush();
        return true;
    }

    // delete resource from the project
    @Override
    public boolean deleteResourceFromProject(int projectId, int resourceId) {
        System.out.println("execute function deleteResourceFromProject");
        // get projectResource by projectId and resourceId
        ProjectResource pr = projectResourceRepository.
                findProjectResourceByProjectAndResourceId(projectId, resourceId);
        System.out.println(pr.toString());
        // get projectResourceId
        int projectResourceId = pr.getProjectResourceId();
        System.out.println("Yuqi Zhou");
        System.out.println("ProjectResource Id: " + projectResourceId);
        // delete projectResource by projectResourceId
        projectResourceRepository.deleteById(projectResourceId);
        projectResourceRepository.flush();
        return true;
    }

}
