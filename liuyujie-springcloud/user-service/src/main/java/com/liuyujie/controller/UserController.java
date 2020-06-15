package com.liuyujie.controller;

import com.liuyujie.pojo.User;
import com.liuyujie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuyishou
 * @date 2020/6/15
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public User queryById(@PathVariable Long id) {


        return userService.qureyById(id);
    }

}
