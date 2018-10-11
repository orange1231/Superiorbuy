package com.cssl.service;

import com.cssl.dao.Sp_product_categoryMapper;
import com.cssl.pojo.Sp_product_category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class Sp_product_categoryServiceImpl implements Sp_product_categoryService {
    @Autowired
    private Sp_product_categoryMapper spcm;
    @Override
    public List<Sp_product_category> FindAllCategory() {
        return spcm.FindAllCategory();
    }
}
