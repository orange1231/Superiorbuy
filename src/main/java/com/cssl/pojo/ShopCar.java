package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ShopCar implements Serializable {
    //购物车实体类
    private Sp_product ep;//产品对象

    private double xiaoji=0;//小计

    private int number=1;//数量 默认是1
}
