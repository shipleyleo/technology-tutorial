package com.leo.example.userapi.controller;

import com.leo.example.userapi.domain.User;
import com.leo.example.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *
 * </p>
 * <p>
 * Copyright:2022.All rights reserved.
 * </p>
 * <p>
 * Company:
 * </p>
 * <p>
 * CreateDate:2022/4/27
 * </p>
 *
 * @author shipleyleo
 * @history Mender:shipleyleo；Date:2022/4/27
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("testList")
    public List<User> testList() {
        List<User> list = userService.getTestList();
        return list;
    }

}
