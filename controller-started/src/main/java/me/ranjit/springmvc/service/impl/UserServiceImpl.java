package me.ranjit.springmvc.service.impl;

import me.ranjit.springmvc.model.NewUserModel;
import me.ranjit.springmvc.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by suzh on 8/29/2017.
 */
public class UserServiceImpl implements UserService {
    private static Map<String, NewUserModel> userMap = new HashMap<>();

    @Override
    public void create(NewUserModel user) {
        userMap.put(user.getUsername(), user);
    }

    @Override
    public void update(NewUserModel user) {
        userMap.put(user.getUsername(), user);
    }

    @Override
    public void delete(NewUserModel user) {
        userMap.remove(user.getUsername());
    }

    @Override
    public List<NewUserModel> list() {
        return userMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public NewUserModel get(String username) {
        return userMap.get(username);
    }
}
