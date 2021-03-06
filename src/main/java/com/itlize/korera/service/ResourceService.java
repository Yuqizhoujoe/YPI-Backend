package com.itlize.korera.service;

import com.itlize.korera.entity.Resource;

import java.util.List;
import java.util.Optional;

                          //////////////////////////////////////////////////////////////////////
                         // RESOURCE SERVICE INTERFACE: GET,ADD,DELETE,GETBYRESID,UPDATE //////
                        //////////////////////////////////////////////////////////////////////


public interface ResourceService {


    public List<Resource> getAllResources();

    public Resource addResource(Resource newResource);

    public List<Resource> addResources(List<Resource> resources);

    public boolean deleteResourceById(Resource newResource);

    public Optional<Resource> getResourceById(int id);

    public Resource updateResourceById(Resource resource);

}
