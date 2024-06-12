package com.example.lesson.Controller;

import com.example.lesson.entity.ProductRecord;
import com.example.lesson.form.AddForm;
import com.example.lesson.form.UpdateForm;
import com.example.lesson.service.PgProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class TestController {

    @Autowired
    PgProductService pgProductService;

    //urlを踏んだら（キャッチして）反応
    @GetMapping("/product-list")
    public String productList(Model model) {
        //model.addAttributeがfindAll.htmlにpgProductService.findAll()つまり（products）を投げる作業を担っている
        model.addAttribute("products", pgProductService.findAll());
        return "findAll";
    }

    @GetMapping("/product/{id}")
    public String findProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", pgProductService.findById(id));
        return "findByid";
    }

    @GetMapping("/product-add")
    public String findProduct(@ModelAttribute("addForm") AddForm addForm) {

        return "addProduct";
    }

    @PostMapping("/product-add")
    public String addproduct(@Validated @ModelAttribute("addForm") AddForm addForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addProduct";
        }
        pgProductService.insert(addForm.getProductName(), addForm.getPrice());
        return "redirect:/product-list";
    }

    @GetMapping("/product/update/{id}")
    public String UpdateProduct(@PathVariable("id") int id, @ModelAttribute("updateForm") UpdateForm updateForm) {
        var product = pgProductService.findById(id);
//        更新の対象のレコードの中身を表示するためfindById(id)の中身をupdateFormに入れる作業
//        これにより、「商品情報更新」画面に飛んだ時に選んだidを持つレコードの中身が表示された状態となっている
        updateForm.setId(product.id());
        updateForm.setProductName(product.name());
        updateForm.setPrice(product.price());
        return "updateProduct";
    }

    @PostMapping("/product/update/{id}")
    public String UpdateProduct(@PathVariable("id") int id, @ModelAttribute("updateForm") UpdateForm updateForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "updateProduct";
        }
        var updateRecord = new ProductRecord(updateForm.getId(), updateForm.getProductName(), updateForm.getPrice());
        pgProductService.update(updateRecord);
//        pgProductService.update(new ProductRecord(updateForm.getId(), updateForm.getProductName(), updateForm.getPrice()));
        return "redirect:/product-list";
    }

    @PostMapping("/product/delete/{id}")
    public String DeleteProduct(@PathVariable("id") int id){
        pgProductService.delete(id);
        return "redirect:/product-list";
    }

}