package com.itlize.korera.repository;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.itlize.korera.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@JsonDeserialize(as = Project.class)
public interface ProjectRepository extends JpaRepository<Project, Integer> {}
