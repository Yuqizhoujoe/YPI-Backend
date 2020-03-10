package com.itlize.korera.controller;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.ProjectResource;
import com.itlize.korera.entity.Resource;
import com.itlize.korera.repository.ProjectRepository;
import com.itlize.korera.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    // field injection - projectService
    @Autowired
    private ProjectService projectService;

    @GetMapping("/project")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping("/project")
    public Project addProject(@RequestBody Project project) {
        return projectService.addProject(project);
    }

    @PostMapping("/projects")
    public void addProjects(@RequestBody List<Project> projects) {
        projectService.addProjects(projects);
    }

    @PutMapping("/project/{id}")
    public void updateProject(@RequestBody Project project) {
        projectService.updateProject(project);
    }

    @DeleteMapping("/project/{id}")
    public void deleteProjectById(@PathVariable int id) {
        projectService.deleteProjectById(id);
    }

}
