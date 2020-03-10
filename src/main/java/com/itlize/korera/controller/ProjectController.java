package com.itlize.korera.controller;


import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.Resource;
import com.itlize.korera.service.ProjectService;
import com.itlize.korera.service.ResourceService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//////////////////////////////////////////////////////////////////////
// PROJECT CONTROLLER: API (ENDPOINTS) POST/GET/PUT/PATCH/DELETE /////
//////////////////////////////////////////////////////////////////////

@RestController
public class ProjectController {

    /////////////////////////////////////
    //// FIELDS(PROJECT:SERVICE) ////////
    /////////////////////////////////////

    @Autowired
    private ProjectService projectService;

    ////////////////////////////////////////////
    //// GET:ALL PROJECTS(LIST)(NO-AUTH)////////
    ////////////////////////////////////////////

    @GetMapping("/projects")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    //////////////////////////////////////
    //// POST:ADD A PROJECT: AUTH ////////
    //////////////////////////////////////


    @PostMapping(value = "/addProject", consumes="application/json")
    @ResponseBody
    public ResponseEntity<Project> create(@RequestBody Project newProject){
        Project newProj = newProject;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "ProjectController");
        try {
            projectService.addProject(newProject);
        } catch(Exception ex) {
            System.out.println("Project not found" + ex.getMessage());
            return ResponseEntity.ok().headers(headers).body(newProj);
        }
        return ResponseEntity.ok().headers(headers).body(newProj);
    }


    //////////////////////////////////////
    //// GET:GET A PROJECT: AUTH /////////
    //////////////////////////////////////

    @GetMapping(value = "/projects/{id}",produces = "application/json")
    public ResponseEntity<Project> getResourceById(@PathVariable @NotNull int id){
        Optional<Project> newProj = null;
        System.out.println(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "ProjectController");
        newProj = projectService.getProjectById(id);
        try {

        } catch(Exception ex) {
            System.out.println("Project not found" + ex.getMessage());
            return ResponseEntity.accepted().headers(headers).body(newProj.get());
        }

        return ResponseEntity.ok().headers(headers).body(newProj.get());
    }

    /////////////////////////////////////////////
    //// GET:RESOURCES BY PROJECT: AUTH /////////
    /////////////////////////////////////////////




    /////////////////////////////////////////
    //// DELETE:REMOVE A PROJECT: AUTH //////
    /////////////////////////////////////////

    @DeleteMapping(value = "projects/delete/{id}",produces ="application/json")
    @ResponseBody
    public String delete(@PathVariable int id) {
        boolean isDeleted = false;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "ProjectController");
        System.out.println(id);
        try {
            Project delProj = new Project(id);
            isDeleted = projectService.deleteProjectById(delProj);
        } catch(Exception ex) {
            System.out.println("Project not found to delete" + ex.getMessage());
            return "Error deleting the Project: " + ex.toString();
        }

        if(isDeleted) {
            return "Project succesfully deleted!";
        }
        return "Error! Project deleted!";
    }


    ////////////////////////////////////////
    //// PUT:UPDATE A PROJECT: AUTH ////////
    ////////////////////////////////////////

    @PutMapping(value = "projects/update/{id}",produces ="application/json")
    public String update(@RequestBody Project project, @PathVariable int id){
        Project isUpdated =  null;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "ProjectController");
        System.out.println(id);
        Optional<Project> projectOptional = projectService.getProjectById(id);
        try {
            project.setProjectId(id);
            isUpdated = projectService.updateProjectById(project);
        } catch(Exception ex) {
            System.out.println("Project not found to delete" + ex.getMessage());
            return "Error deleting the Project: " + ex.toString();
        }


        if(projectOptional.isPresent()) {
            return "Project succesfully Updated!";
        }
        return "Error! Project updated!";
    }


}