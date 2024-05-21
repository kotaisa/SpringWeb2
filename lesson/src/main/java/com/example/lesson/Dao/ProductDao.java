package com.example.lesson.Dao;

import com.example.lesson.entity.ProductRecord;

import java.util.List;

public interface ProductDao {
    ProductRecord findById(int id);

    List<ProductRecord> findAll();

    int insert(ProductRecord userRecord);

    int update(ProductRecord userRecord);

    int delete(int id);
}
