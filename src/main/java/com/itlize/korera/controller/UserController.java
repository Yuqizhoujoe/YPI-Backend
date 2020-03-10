package com.itlize.korera.controller;

import com.itlize.korera.config.JwtTokenUtil;
import com.itlize.korera.dto.UserDto;
import com.itlize.korera.entity.User;
import com.itlize.korera.model.JwtResponse;
import com.itlize.korera.service.JwtUserDetailService;
import com.itlize.korera.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@RestController
@Validated
@RequestMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUserDetailService jwtUserDetailService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @GetMapping("/user")
    public List<User> getAllUser() throws IOException {
        System.out.println("getAllUser");
        return userService.getAllUser();}

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) throws Exception {
        User user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUserById(@PathVariable int id, @RequestBody User user) throws Exception {
        userService.updateUserById(id,user);
        return ResponseEntity.ok().body("User: "+id+" Updated");
    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable int id) throws Exception {
        userService.deleteUserById(id);
        return ResponseEntity.ok().body("User: "+id+"Deleted");
    }

    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody UserDto newUserDto){
        if(newUserDto == null) return ResponseEntity.badRequest().body("Cannot add Empty user");

        /*
        System.out.println(newUser);
        System.out.println(newUser.getUsername());
        System.out.println(newUser.getUserPassword());
        System.out.println(newUser.getUserTitle());
        System.out.println(newUser.getUserRegisterDate());
        System.out.println(newUser.getUserId());

         */

        System.out.println("LOGIN: " + newUserDto.toString());
        User user = userService.getUserByUsername(newUserDto.getUsername());
        if(user != null) return ResponseEntity.badRequest().body("Username: "+ newUserDto.getUsername()+" already Exist");

        System.out.println("postUser");
        User newUser = userService.addUser(newUserDto);
        final UserDetails userDetails = jwtUserDetailService
                .loadUserByUsername(newUser.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        System.out.println("postAddition");
        return ResponseEntity.ok().body(new JwtResponse(token));
    }
    /*
    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        modelMap.put("User", userService.findAll());
        ret
        */

}
