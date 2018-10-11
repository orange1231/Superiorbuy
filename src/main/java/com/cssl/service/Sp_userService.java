package com.cssl.service;

import com.cssl.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/*
用户接口
 */
public interface Sp_userService {
    //登录
    public Sp_user Login(Sp_user user);
    //注册
    public boolean Register(Sp_user user);
    //判断用户是否存在
    public boolean Is_Exists_User(String su_account);
    //手机号登录
    public Sp_user Login1(Sp_user user);
    //待电子邮件登录
    public Sp_user Login2(Sp_user user);

    //商品分类
    public List<Sp_product> selectBySpc_id(int spc_id);
    //查找零食
    public List<Sp_product> findls();

    //查询二级分类名称
    public List<Sp_product_category> selectSpc_name(int spc_parent_id);

    //首页二级分类下随机产生的六个商品图片
    public List<Sp_product> selectCenter(@Param("s1") int s1, @Param("s2") int s2);

    //商品排行
    public List<Sp_product> selectRank(@Param("sell1") int sell1,@Param("sell2") int sell2);
    /*
    商品--首页
     */
    //特别推荐：每次随机挑选四个商品
    public List<Sp_product> Special_Recommendation();
    //商品热门：根据销量
    public List<Sp_product> Commodity_Hot();
    //新品上架：根据上架时间
    public List<Sp_product> New_Product();
    /*
   商品详情--goods.html
    */
    //商品详情
    public Sp_product Commodity_Details(int sp_id);
    //图片介绍（小图片）
    public List<Sp_product_picture> Picture_Details(int sp_id);
    //查询评论条数
    public String Sc_Concent_Count(int sp_id);
    //查询运费
    public Sp_freight Sel_Sp_Freight(int sp_id);
    //根据商品id查询商品评价
    public List<Sp_user> Sel_Sp_Comments(int sp_id);
    //当前位置
    public Sp_product_category Current_Location(int sp_id);
    //获取商品子类
    public Sp_product_category Get_Subclass(int spc_file_id);

}
