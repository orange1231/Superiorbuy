package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

//订单
@Setter
@Getter
public class Sp_order {
    private Integer so_id;//订单ID
    private Integer so_user_id;//用户名
    private String so_user_name;//真实姓名
    private Integer sa_id;//与收货地址表ID关联
    private Date so_create_time;//下单时间
    private double so_cost;//总金额
    private Integer so_status;//1-待审核，2-通过审核，3配货中，4-已发货，5-已收货
    private Integer so_type;//1-支付宝支付，2银联支付
    private String so_serial;//订单编号
}
