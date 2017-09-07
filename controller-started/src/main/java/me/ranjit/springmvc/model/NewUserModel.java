package me.ranjit.springmvc.model;

import lombok.Data;

/**
 * Created by suzh on 8/29/2017.
 */
@Data
public class NewUserModel {
    private String username;
    private String password;
    private String realname; //真实姓名
    private SchoolInfoModel schoolInfo;
    private WorkInfoModel workInfo;
}
