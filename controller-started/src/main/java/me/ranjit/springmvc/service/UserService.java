package me.ranjit.springmvc.service;

import me.ranjit.springmvc.model.NewUserModel;

import java.util.List;

/**
 * Created by suzh on 8/29/2017.
 */
public interface UserService {
    void create(NewUserModel user);
    void update(NewUserModel user);
    void delete(NewUserModel user);
    List<NewUserModel> list();
    NewUserModel get(String username);
}
