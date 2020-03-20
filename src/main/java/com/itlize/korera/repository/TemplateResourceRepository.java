package com.itlize.korera.repository;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.itlize.korera.dto.TemplateResourceDTO;
import com.itlize.korera.entity.Template;
import com.itlize.korera.entity.TemplateResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@JsonDeserialize(as = TemplateResource.class)
public interface TemplateResourceRepository extends JpaRepository<TemplateResource, Integer> {

    // find the TemplateResource by projectId
    @Query(value = "SELECT tr FROM TemplateResource tr " +
            "WHERE tr.template.project.ProjectId = :ProjectId")
    public Set<TemplateResource> findTemplateResourceByProjectId(@Param("ProjectId") int projectId);

    // find the TemplateResource by resourceId
    @Query(value = "SELECT tr FROM TemplateResource tr " +
            "WHERE tr.resource.ResourceId = :ResourceId ORDER BY tr.template.TemplateId ASC")
    public Set<TemplateResource> findTemplateResourceByResourceId(@Param("ResourceId") int resourceId);

    // find the biggest templateResourceId
    @Query("SELECT tr FROM TemplateResource tr ORDER BY tr.TemplateResourceId DESC")
    public List<TemplateResource> findTheBiggestTemplateResourceId();

}
