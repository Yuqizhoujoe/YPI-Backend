package com.itlize.korera.service;

import com.itlize.korera.dto.UserDto;
import com.itlize.korera.entity.User;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public interface UserService {

    public List<User> getAllUser() throws IOException;
    public User getUserById(int userId) throws Exception;
    public User getUserByUsername(String username);
    public void deleteUserById(int userId) throws Exception;
    public void updateUserById(int userId, User user) throws Exception;
    public User addUser(UserDto user);
    //public Iterable<User> findAll();
}
