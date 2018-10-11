package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

/*
行政区域地州市信息表
 */
public class Sp_cities {
    private int id;            //唯一id
    private String cityid;     //城市id
    private String city;       //城市名称
    private String provinceid;//省份id
}
