package com.example.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("managementUser")
@PreAuthorize("hasRole('ADMIN')")
public class ManagementUserController{
    // CRU User
    @GetMapping("createUser")
    public String createUser(){
        return "add Brand";
    }
    @GetMapping("readProduct ")
    public String readUSer(){
        return "read Brand ";
    }
    @GetMapping("updateUser")
    public String updateUser(){
        return "update User";
    }
    // Read Info User , Changle Info User
    @PreAuthorize("hasRole('USER')")
    @GetMapping("InfoUser")
    public String getInfo(){
        return "Info User";
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("changleUser")
    public String changleUser(){
        return "changle User";
    }













}

