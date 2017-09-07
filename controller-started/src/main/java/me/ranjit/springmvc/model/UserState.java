package me.ranjit.springmvc.model;

import lombok.Getter;

/**
 * Created by suzh on 8/30/2017.
 */
@Getter
public enum UserState {
    blocked("b", "锁定"),
    enabled("e", "解锁");

    private String name;
    private String value;

    UserState(String name, String value){
        this.name = name;
        this.value = value;
    }
}
