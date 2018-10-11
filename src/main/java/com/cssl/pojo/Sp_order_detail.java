package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

/*
订单详情表
 */
public class Sp_order_detail {
    private int sod_id;       //详情id
    private int so_id;        //订单id
    private int sp_id;        //商品id
    private int sod_quantity;//数量
    private double sod_cost; //小计(单价*数量)
}
