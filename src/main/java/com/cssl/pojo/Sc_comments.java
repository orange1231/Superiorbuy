package com.cssl.pojo;

import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

//评论
@Setter
@Getter
public class Sc_comments {
    private Integer sc_id;//评论id
    private Integer sc_comments_type;//1-好评 2-中评 3-差评
    private Integer su_id;//引用用户id
    private Integer sp_id;//引用商品id
    private Integer sic_id;//引用图片id
    private Date sc_date;//留言时间
    private String sc_concent;//评论内容


}
