package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

/*
商品表
 */
public class Sp_product {
    private int sp_id;             //商品id
    private String sp_name;        //商品名称
    private String sp_description;//商品描述
    private double sp_price;      //商品价格
    private int sp_stock;         //库存
    private int spc_id;           //类别id
    private int spc_file_id;     //二级分类id
    private String sp_photo;     //商品图片
    private int sp_isfree;       //是否需要邮费
    private int sp_sell;         //销售量
}
