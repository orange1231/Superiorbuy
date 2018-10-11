package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

/*
运费表
 */
@Setter
@Getter
public class Sp_freight {
    private Integer sf_id;      //运费id
    private Integer sp_isfree;  //是否免运费（1、免运费 2、邮费）
    private String sp_freight_price;    //运费
    private Integer sp_id;      //引用商品id

}

