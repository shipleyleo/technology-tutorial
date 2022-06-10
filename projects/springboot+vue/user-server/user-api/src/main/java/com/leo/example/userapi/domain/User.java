package com.leo.example.userapi.domain;

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
public class User {
    //用户名
    private String name;
    //密码
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
