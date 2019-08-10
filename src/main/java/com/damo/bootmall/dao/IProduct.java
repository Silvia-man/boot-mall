package com.damo.bootmall.dao;

import com.damo.bootmall.bean.Product;

public interface IProduct {
    int insert(Product product);
    int updateById(Product product);
    int deleteById(int id);
    Product getById(int id);
    Product getByName(String name);
}
