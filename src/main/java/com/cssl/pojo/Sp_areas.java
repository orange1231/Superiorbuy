package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

/*
行政区域县区信息表
 */
public class Sp_areas {
    private int id;        //唯一id
    private String areaid; //区域id
    private String area;   //区域名称
    private String cityid; //城市id
}
