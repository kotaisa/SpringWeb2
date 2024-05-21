package com.example.lesson.service;

import com.example.lesson.entity.ProductRecord;

import java.util.List;

public interface ProductService {
    ProductRecord findById(int id);
    List<ProductRecord> findAll();
    int insert(ProductRecord p);
    int update(ProductRecord p);
    int delete(int id);
}
