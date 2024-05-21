package com.example.lesson.Dao;

import com.example.lesson.entity.ProductRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PgProductDao implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    @Override
    public ProductRecord findById(int id) {
        var param = new MapSqlParameterSource();
        param.addValue("id", id);
        var list = jdbcTemplate.query("SELECT * FROM products WHERE id = :id", param, new DataClassRowMapper<>(ProductRecord.class));
        return list.isEmpty() ? null : list.get(0);
    }

    @Override
    public List<ProductRecord> findAll() {
        return jdbcTemplate.query("SELECT * FROM products ORDER BY id",
                new DataClassRowMapper<>(ProductRecord.class));
    }

    @Override
    public int insert(ProductRecord userRecord) {
        var param = new MapSqlParameterSource();
        param.addValue("id", userRecord.id());
        param.addValue("name", userRecord.name());
        param.addValue("price", userRecord.price());
        return jdbcTemplate.update("INSERT INTO products VALUES(:id, :name, :price)", param);
    }

    @Override
    public int update(ProductRecord userRecord) {
        var param = new MapSqlParameterSource();
        param.addValue("name", userRecord.name());
        param.addValue("price", userRecord.price());
        param.addValue("id", userRecord.id());
        return jdbcTemplate.update("UPDATE products SET name = :name, price =:price WHERE id = :id", param);
    }

    @Override
    public int delete(int id) {
        var param = new MapSqlParameterSource();
        param.addValue("id", id);
        return jdbcTemplate.update("DELETE FROM products WHERE id = :id", param);
    }
}
