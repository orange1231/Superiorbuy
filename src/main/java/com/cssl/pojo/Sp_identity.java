package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

//身份证照片
@Setter
@Getter
public class Sp_identity {
    private Integer dentity_id;//身份证照片id
    private Integer su_id;//与用户表id关联
    private String identity_photo;//身份证照片
    private Integer identity_face;//1为正面，2为反面
}
