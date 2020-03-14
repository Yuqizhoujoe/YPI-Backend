package com.itlize.korera.repository;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.itlize.korera.entity.Resource;
import com.itlize.korera.entity.User;
import org.json.simple.JSONArray;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@JsonDeserialize(as = Resource.class)
public interface UserRepository extends JpaRepository<User, Integer>{

    public User findByUsername(String username);
}
