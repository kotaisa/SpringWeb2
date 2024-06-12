package com.example.lesson.service;

import com.example.lesson.Dao.PgProductDao;
import com.example.lesson.ProductNotFoundException;
import com.example.lesson.entity.ProductRecord;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class PgProductService implements ProductService {

    private PgProductDao productDao;

//    @Override
//    public ProductRecord findById(int id) {
//        try {
//            ProductRecord productRecord = productDao.findById(id);
//            if (productRecord == null) {
//                throw new ProductNotFoundException();
//            }
//            return productDao.findById(id);
//        } catch (DataAccessException e) {
//            return null;
//        }
//    }

    @Override
    public ProductRecord findById(int id) {

        return productDao.findById(id);
    }

    @Override
    public List<ProductRecord> findAll() {

        return productDao.findAll();
    }

    @Override
    public int insert(String name, int price) {

        return productDao.insert(name, price);

//        try {
//            return productDao.insert(name, price);
//        } catch (DataAccessException e) {
//            return 0;
//        }
    }

    @Override
    public int update(ProductRecord p) {
        return productDao.update(p);
    }

    @Override
    public int delete(int id) {
        return productDao.delete(id);
    }
}
