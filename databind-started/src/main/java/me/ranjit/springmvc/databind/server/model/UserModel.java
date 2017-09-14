package me.ranjit.springmvc.databind.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by suzh on 9/8/2017.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModel {
    private String username;
    private String password;
}
