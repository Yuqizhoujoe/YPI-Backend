package com.itlize.korera.repository;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.itlize.korera.entity.ProjectResource;
import com.itlize.korera.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@JsonDeserialize(as = Resource.class)
public interface ProjectResourceRepository extends JpaRepository<ProjectResource, Integer> {

    // find projectResources by projectId
    @Query("SELECT pr FROM ProjectResource pr WHERE pr.project.ProjectId = :ProjectId")
    public List<ProjectResource> findByProjectId(@Param("ProjectId") int projectId);

    // find projectResource by projectId and projectResourceId
    @Query("SELECT pr FROM ProjectResource pr WHERE pr.project.ProjectId = :ProjectId " +
            "AND pr.ProjectResourceId = :ProjectResourceId")
    public ProjectResource findProjectResourceByProjectResourceId(
            @Param("ProjectId") int projectId,
            @Param("ProjectResourceId") int projectResourceId);

    // find projectResource by projectId and resourceId
    @Query("SELECT pr FROM ProjectResource pr WHERE pr.project.ProjectId = :ProjectId " +
            "AND pr.resource.ResourceId = :ResourceId")
    public ProjectResource findProjectResourceByProjectAndResourceId(
              @Param("ProjectId") int projectId,
              @Param("ResourceId") int resourceId
    );

/*
    @Transactional
    @Modifying
    @Query(
        value = "INSERT INTO ProjectResource (ProjectId, ResourceId) VALUES (:ProjectId, :ResourceId)",
        nativeQuery = true
    )
    public void addProjectResource(@Param("ProjectId") int ProjectId, @Param("ResourceId") int ResourceId);
*/

}
