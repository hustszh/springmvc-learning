package me.ranjit.springmvc.model;

import lombok.Data;

/**
 * Created by suzh on 8/29/2017.
 */
@Data
public class SchoolInfoModel {
    private String schoolType; //学校类型：高中、中专、大学
    private String schoolName; //学校名称
    private String specialty; //专业
}
