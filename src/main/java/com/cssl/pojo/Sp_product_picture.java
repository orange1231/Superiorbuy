package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

/*
商品图片与描述图片表
 */
public class Sp_product_picture {
    private int sic_id;      //图片id
    private int sic_pid;     //商品id
    private String sic_photo;//图片路径
    private int sic_type;    //图片作用id
}
