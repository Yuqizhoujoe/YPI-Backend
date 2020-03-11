package com.itlize.korera.service;

import com.itlize.korera.entity.User;
import com.itlize.korera.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailService implements UserDetailsService {
   @Autowired
   UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        User user = userService.getUserByUsername(username);

        System.out.println("Find user");
        //System.out.println(user.toString());
        if(user == null) {
            System.out.println("user not found");
            //return new org.springframework.security.core.userdetails.User(null,null,new ArrayList<>());
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        System.out.println("User Found");
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getUserPassword(),new ArrayList<>());

        /*
        if ("admin".equals(username)) {
            return new org.springframework.security.core.userdetails.User("admin", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

         */
    }


}
