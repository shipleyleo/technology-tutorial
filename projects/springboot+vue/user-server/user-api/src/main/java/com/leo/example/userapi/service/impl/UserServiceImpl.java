package com.leo.example.userapi.service.impl;

import com.leo.example.userapi.domain.User;
import com.leo.example.userapi.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getTestList() {
        List<User> list = new ArrayList<>();
        for(int i=0; i<3; i++) {
            User user = new User("username_"+i, "password_"+i);
            list.add(user);
        }
        return list;
    }

}
