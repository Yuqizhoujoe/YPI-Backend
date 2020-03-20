package com.itlize.korera.repository;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.itlize.korera.entity.Project;
import com.itlize.korera.entity.ProjectResource;
import com.itlize.korera.entity.Template;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@JsonDeserialize(as = Template.class)
public interface TemplateRepository extends JpaRepository<Template, Integer> {

    // find template bt templateId
    @Query("SELECT t FROM Template t WHERE t.TemplateId = :TemplateId")
    public Template findByTemplateId(@Param("TemplateId") int TemplateId);

    // find template by projectId
    @Query("SELECT t FROM Template t WHERE t.project.ProjectId = :ProjectId ORDER BY t.TemplateId")
    public List<Template> findByProjectId(@Param("ProjectId") int projectId);

    // find the biggest templateId
    @Query("SELECT t FROM Template t ORDER BY t.TemplateId DESC")
    public List<Template> findTheBiggestTemplateId();

}
