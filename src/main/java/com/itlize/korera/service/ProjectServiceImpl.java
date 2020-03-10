package com.itlize.korera.service;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.ProjectResource;
import com.itlize.korera.entity.Resource;
import com.itlize.korera.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService{

    // field injection
    @Autowired
    private ProjectRepository projectRepository;

    // get all projects from Project table
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // get project by id
    @Override
    public Project getProjectById(int id) {
        return projectRepository.findById(id).get();
    }

    // create new project
    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }

    // add a list of projects
    @Override
    public void addProjects(List<Project> projects) {
        for (Project p : projects) {
            projectRepository.save(p);
        }
    }

    // update project
    @Override
    public void updateProject(Project project) {
        projectRepository.save(project);
    }

    // delete project by id
    @Override
    public void deleteProjectById(int id) {
        projectRepository.deleteById(id);
    }


}

/*    // create new project with projectResoueces
    @Override
    public Project createProjectWithResources(ProjectResource projectResource) {
        // create Project object
        Project project = projectResource.getProject();
        // add the ProjectResource into the ProjectResource List in Project
        project.addProjectResources(projectResource);
        // save the project
        return projectRepository.save(project);
    }*/