package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

/*
用户表
 */
public class Sp_user {
    private int su_id;                  //用户id
    private String su_account;          //账号
    private String su_name;             //姓名
    private String su_password;         //密码
    private String su_sex;              //性别
    private String su_email;            //邮箱
    private String su_mobile;           //手机
    private String su_identity_code;   //省份证号码
    private int su_identity_photo_id; //省份证照片
    private int su_isadmin;            //是否是管理员
}
