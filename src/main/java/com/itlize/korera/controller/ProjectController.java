package com.itlize.korera.controller;

import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.Resource;
import com.itlize.korera.service.ProjectService;
import com.itlize.korera.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping(value = "/addProject", consumes="application/json")
    @ResponseBody
    public ResponseEntity<Project> create(@RequestBody Project newProject){
        Project proj = newProject;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "ResourceController");
        try {
            projectService.addProject(newProject);
        } catch(Exception ex) {
            System.out.println("Project not found" + ex.getMessage());
            return ResponseEntity.ok().headers(headers).body(proj);
        }
        return ResponseEntity.ok().headers(headers).body(proj);
    }




}
