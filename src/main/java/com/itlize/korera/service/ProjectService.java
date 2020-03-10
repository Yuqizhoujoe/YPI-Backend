package com.itlize.korera.service;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.Resource;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    public List<Project> getAllProjects();

    public Project addProject(Project newProject);

    public boolean deleteProjectById(Project newProject);

    public Optional<Project> getProjectById(int id);

    public Project updateProjectById(Project project);
}
