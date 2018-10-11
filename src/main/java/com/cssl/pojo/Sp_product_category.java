package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

/*
商品类别表
 */
public class Sp_product_category {
    private int spc_id;       //类别id
    private String spc_name;  //类别名称
    private int spc_parent_id;//父类id
}
