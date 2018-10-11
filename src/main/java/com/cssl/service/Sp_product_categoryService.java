package com.cssl.service;

import com.cssl.pojo.Sp_product_category;

import java.util.List;

public interface Sp_product_categoryService {
    //首页图片轮播旁边悬浮二级分类显示该分类的商品--王婷
    public List<Sp_product_category> FindAllCategory();
}
