package com.leo.example.hello.controller;

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
 * Company:Zsoft
 * </p>
 * <p>
 * CreateDate:2022/4/8
 * </p>
 *
 * @author liaoxiaopeng
 * @history Mender:liaoxiaopeng；Date:2022/4/8
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello world!";
    }

}
