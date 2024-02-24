package com.springbootsecurityrevesion.Controller;

import com.springbootsecurityrevesion.Dto.CategoryDto;
import com.springbootsecurityrevesion.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save-category")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto response = this.categoryService.saveCategory(categoryDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
