package com.leo.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
 * CreateDate:2022/4/21
 * </p>
 *
 * @author shipleyleo
 * @history Mender:shipleyleo；Date:2022/4/21
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/welcome")
    public String welcome() {
        return "Hello! Welcome to use Spring Boot!";
    }

}
