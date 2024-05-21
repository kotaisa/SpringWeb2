package com.example.lesson;

import com.example.lesson.entity.ProductRecord;
import com.example.lesson.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LessonApplication {

    public static void main(String[] args) {
        var context = SpringApplication.run(LessonApplication.class, args);
        var p = context.getBean(ProductService.class);

//        var list = p.findAll();
//        list.forEach(System.out::println);

//        var product = p.findById(1);
//        System.out.println(product);


//        var insert = p.insert(new ProductRecord(4, "上履き", 7000));
//        System.out.println(insert + "件更新しました");


//        var update = p.update(new ProductRecord(3, "ランドセル", 50000));
//        System.out.println(update + "件更新しました");


//        var delete = p.delete(4);
//        System.out.println(delete + "件更新しました");
    }
}
