package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;

//商品图片与描述图片
@Setter
@Getter
public class Sp_index_pictures {
    private Integer sip_id;//id
    private String sip_photo;//图片路径
    private Integer sp_id;//图片商品链接ID(与商品表ID关联)

}
