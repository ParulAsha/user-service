package com.codebuffer.userservice.controller;

import com.codebuffer.userservice.VO.ResponseTemplateVO;
import com.codebuffer.userservice.entity.User;
import com.codebuffer.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/")
    public User saveUser(@RequestBody User user)
    {
        log.info("inside saveUser method of controller");
        return userService.saveUsers(user);
    }
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment( @PathVariable("id") Long userId)
           // public String getdepartment()
    { log.info("inside get users with department");
        return userService.getUserWithDepartment(userId);
       // return "Parul";
    }
}
