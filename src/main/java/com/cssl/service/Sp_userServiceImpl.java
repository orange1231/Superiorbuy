package com.cssl.service;

import com.cssl.dao.Sp_userMapper;
import com.cssl.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Sp_userServiceImpl implements  Sp_userService{
    @Autowired
    public Sp_userMapper sp_userMapper;
    //登录
    @Override
    public Sp_user Login(Sp_user user) {

        return sp_userMapper.Login(user);
    }
    //注册
    @Override
    public boolean Register(Sp_user user) {
        return sp_userMapper.Register(user)>0?true:false;
    }

    //判断用户是否存在
    @Override
    public boolean Is_Exists_User(String su_account) {
        return sp_userMapper.Is_Exists_User(su_account)>0;
    }
    @Override
    public Sp_user Login1(Sp_user user) {
        return  sp_userMapper.Login1(user);
    }

    @Override
    public Sp_user Login2(Sp_user user) {
        return sp_userMapper.Login2(user);
    }

    @Override
    public List<Sp_product> selectBySpc_id(int spc_id) {
        return sp_userMapper.selectBySpc_id(spc_id);
    }

    @Override
    public List<Sp_product> findls() {
        return sp_userMapper.findls();
    }

    @Override
    public List<Sp_product_category> selectSpc_name(int spc_parent_id) {
        return sp_userMapper.selectSpc_name(spc_parent_id);
    }

    @Override
    public List<Sp_product> selectCenter(int s1, int s2) {
        return sp_userMapper.selectCenter(s1,s2);
    }

    @Override
    public List<Sp_product> selectRank(int sell1, int sell2) {
        return sp_userMapper.selectRank(sell1,sell2);
    }
    /*
    商品--首页
     */
    //特别推荐：每次随机挑选四个商品
    @Override
    public List<Sp_product> Special_Recommendation() {
        return sp_userMapper.Special_Recommendation();
    }
    //商品热门：根据销量
    @Override
    public List<Sp_product> Commodity_Hot() {
        return sp_userMapper.Commodity_Hot();
    }
    //新品上架：根据上架时间
    @Override
    public List<Sp_product> New_Product() {
        return sp_userMapper.New_Product();
    }
    /*
       商品详情--goods.html
     */
    //商品详情
    @Override
    public Sp_product Commodity_Details(int sp_id) {
        return sp_userMapper.Commodity_Details(sp_id);
    }
    //图片介绍（小图片）
    @Override
    public List<Sp_product_picture> Picture_Details(int sp_id) {
        return sp_userMapper.Picture_Details(sp_id);
    }
    //查询评论条数
    @Override
    public String Sc_Concent_Count(int sp_id) {
        return sp_userMapper.Sc_Concent_Count(sp_id);
    }
    //查询运费
    @Override
    public Sp_freight Sel_Sp_Freight(int sp_id) {
        return sp_userMapper.Sel_Sp_Freight(sp_id);
    }
    //根据商品id查询商品评价
    @Override
    public List<Sp_user> Sel_Sp_Comments(int sp_id) {
        return sp_userMapper.Sel_Sp_Comments(sp_id);
    }
    //当前位置
    @Override
    public Sp_product_category Current_Location(int sp_id) {
        return sp_userMapper.Current_Location(sp_id);
    }
    //获取商品子类
    @Override
    public Sp_product_category Get_Subclass(int spc_file_id) {
        return sp_userMapper.Get_Subclass(spc_file_id);
    }
}
