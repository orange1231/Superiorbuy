package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

//收货地址
@Setter
@Getter
public class Sp_address {
    private Integer sa_id;//地址id
    private String sa_name;//收货人姓名
    private String sa_address;//收货地址
    private String sa_code;//邮编
    private String sa_phone;//收货人手机
    private String sa_call;//收货人电话
    private Integer su_id;//引用用户ID
}
