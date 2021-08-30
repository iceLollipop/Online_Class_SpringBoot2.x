package net.onlineclass.service;

import net.onlineclass.domain.User;

import java.util.List;

public interface UserService {
    String login(String username,String pwd);

    List<User> listUser();
}
