package org.zzzzzz.service.impl;

import org.springframework.stereotype.Service;
import org.zzzzzz.pojo.User;
import org.zzzzzz.service.UserService;

import java.util.ArrayList;


@Service
public class UserServiceImpl implements UserService {

    private final ArrayList<User> userList = new ArrayList<>();

    @Override
    public void save(User user) {
        userList.add(user);
    }

    @Override
    public ArrayList<User> list() {
        return userList;
    }

    @Override
    public void removeAll() {
        userList.clear();
    }
}
