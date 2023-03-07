package org.zzzzzz.service;

import org.zzzzzz.pojo.User;

import java.util.ArrayList;

public interface UserService {

    void save(User user);

    ArrayList<User> list();

    void removeAll();

}
