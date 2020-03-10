package com.itlize.korera.service;

import com.itlize.korera.dto.UserDto;
import com.itlize.korera.entity.Resource;
import com.itlize.korera.entity.User;
import com.itlize.korera.repository.UserRepository;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int userId) throws Exception {
        return userRepository.findById(userId).orElseThrow(Exception::new);
    }

    @Override
    public User getUserByUsername(String username){
        List<User> users= getAllUser();

        for(User user : users){
            if(user.getUsername() == username){ return user;}
        }

        return null;

    }
    @Override
    public void updateUserById(int userId,User newUser) throws Exception {
        User user = getUserById(userId);

        user.setUsername(newUser.getUsername());
        user.setUserPassword(newUser.getUserPassword());
        user.setUserTitle(newUser.getUserTitle());

    }
    @Override
    public void deleteUserById(int userId) throws Exception {
        User user = getUserById(userId);
        userRepository.delete(user);
    }

    @Override
    public User addUser(UserDto userDto){
        System.out.println("preEncryption");
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setUserPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setUserTitle(userDto.getTitle());

        System.out.println(user.getUsername());
        System.out.println(user.getUserPassword());
        System.out.println(user.getUserTitle());

        System.out.println("postENcription");
        User saved = userRepository.save(user);
        System.out.println("Saved");
        return saved;
    }

}
