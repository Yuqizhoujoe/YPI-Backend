package com.itlize.korera.controller;

import com.itlize.korera.entity.Resource;
import com.itlize.korera.service.ResourceService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

                      /////////////////////////////////////////////////////////////////////
                     //RESOURCE CONTROLLER: API (ENDPOINTS) POST/GET/PUT/PATCH/DELETE/////
                    /////////////////////////////////////////////////////////////////////


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ResourceController {

      /////////////////////////////////////
     //// FIELDS(RESOURCE:SERVICE) ///////
    /////////////////////////////////////

    @Autowired
    private ResourceService resourceService;

      ////////////////////////////////////////////
     //// GET:ALL RESOURCES(LIST)(NO-AUTH)///////
    ////////////////////////////////////////////


    @GetMapping("/resources")
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

      //////////////////////////////////////
     //// POST:ADD A RESOURCE: AUTH ///////
    //////////////////////////////////////

    @PostMapping(value = "/addResource", consumes="application/json")
    @ResponseBody
    public ResponseEntity<Resource> create(@RequestBody Resource newResource){
        Resource emp = newResource;
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "ResourceController");
        try {
            resourceService.addResource(newResource);
        } catch(Exception ex) {
            System.out.println("Resource not found" + ex.getMessage());
            return ResponseEntity.ok().headers(headers).body(emp);
        }
        return ResponseEntity.ok().headers(headers).body(emp);
    }

    //////////////////////////////////////
    //// POST:ADD RESOURCES: AUTH ///////
    //////////////////////////////////////

    @PostMapping(value = "/addResources", consumes="application/json")
    @ResponseBody
    public List<Resource> addResourceLists(@RequestBody List<Resource> resources){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "ResourceController");
        try {
            resourceService.addResources(resources);
        } catch (Exception ex) {
            System.out.println("Resources cannot be added " + ex.getMessage());
        }
        return resources;
    }

      //////////////////////////////////////
     //// GET:GET A RESOURCE: AUTH ////////
    //////////////////////////////////////


    @GetMapping(value = "/resources/{id}",produces = "application/json")
    public ResponseEntity<Resource> getResourceById(@PathVariable @NotNull int id){
        Optional<Resource> emp = null;
        System.out.println(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Responded", "ResourceController");
        try {
            emp = resourceService.getResourceById(id);
        } catch(Exception ex) {
            System.out.println("Resource not found" + ex.getMessage());
            return ResponseEntity.accepted().headers(headers).body(emp.get());
        }

        return ResponseEntity.ok().headers(headers).body(emp.get());
    }

      /////////////////////////////////////////
     //// DELETE:REMOVE A RESOURCE: AUTH /////
    /////////////////////////////////////////

   @DeleteMapping(value = "resource/delete/{id}",produces ="application/json")
   @ResponseBody
   public String delete(@PathVariable int id) {
       boolean isDeleted = false;
       HttpHeaders headers = new HttpHeaders();
       headers.add("Content-Type", "application/json");
       headers.add("Responded", "ResourceController");
       System.out.println(id);
       try {
           Resource emp = new Resource(id);
           isDeleted = resourceService.deleteResourceById(emp);
       } catch(Exception ex) {
           System.out.println("Resource not found to delete" + ex.getMessage());
           return "Error deleting the Resource: " + ex.toString();
       }

       if(isDeleted) {
           return "Resource succesfully deleted!";
       }
       return "Error! Resource deleted!";
   }

      ////////////////////////////////////////
     //// PUT:UPDATE A RESOURCE: AUTH ///////
    ////////////////////////////////////////

   @PutMapping(value = "resource/update/{id}",produces ="application/json")
   public String update(@RequestBody Resource resource, @PathVariable int id){
       Resource isUpdated =  null;
       HttpHeaders headers = new HttpHeaders();
       headers.add("Content-Type", "application/json");
       headers.add("Responded", "ResourceController");
       System.out.println(id);
       Optional<Resource> resourceOptional = resourceService.getResourceById(id);
       try {
           resource.setResourceId(id);
           isUpdated = resourceService.updateResourceById(resource);
       } catch(Exception ex) {
           System.out.println("Resource not found to delete" + ex.getMessage());
           return "Error deleting the Resource: " + ex.toString();
       }


       if(resourceOptional.isPresent()) {
           return "Resource succesfully Updated!";
       }
       return "Error! Resource updated!";
   }

}
