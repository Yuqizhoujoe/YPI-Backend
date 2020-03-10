package com.itlize.korera.service;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.ProjectResource;
import com.itlize.korera.entity.Resource;

import java.util.List;

public interface ProjectService {

    // get all projects from Project Table
    public List<Project> getAllProjects();

    // get project by id
    public Project getProjectById(int id);

    // Create new project
    public Project addProject(Project project);

    // add a list of projects
    public void addProjects(List<Project> projects);

    // update project by id
    public void updateProject(Project project);

    // delete project
    public void deleteProjectById(int id);

}
