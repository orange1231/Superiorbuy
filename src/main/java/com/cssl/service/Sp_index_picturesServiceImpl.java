package com.cssl.service;

import com.cssl.dao.Sp_index_picturesMapper;
import com.cssl.pojo.Sp_index_pictures;
import com.cssl.pojo.Sp_product_picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class Sp_index_picturesServiceImpl implements Sp_index_picturesService {

    @Autowired
   public Sp_index_picturesMapper sipm;
    //首页图片轮播旁边悬浮二级分类显示该分类的商品--王婷
    @Override
    public List<Sp_index_pictures> Index_pictures() {
        return sipm.Index_pictures();
    }
}
