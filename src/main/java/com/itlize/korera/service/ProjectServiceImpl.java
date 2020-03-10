package com.itlize.korera.service;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.Resource;
import com.itlize.korera.repository.ProjectRepository;
import com.itlize.korera.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project addProject(Project newProject) {
        projectRepository.save(newProject);
        return newProject;
    }

    @Override
    public boolean deleteProjectById(Project newProject) {
        projectRepository.delete(newProject);
        return true;
    }

    @Override
    public Optional<Project> getProjectById(int id) {
        Optional<Project> newProject = null;

        newProject = projectRepository.findById(id);
        return newProject;
    }

    @Override
    public Project updateProjectById(Project project) {
        projectRepository.save(project);
        return project;
    }
}
