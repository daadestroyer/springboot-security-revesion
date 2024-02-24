package com.springbootsecurityrevesion.Controller;

import com.springbootsecurityrevesion.Dto.CategoryDto;
import com.springbootsecurityrevesion.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @PostMapping("/save-category")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto response = this.categoryService.saveCategory(categoryDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get-single-category/{catId}")
    public ResponseEntity<?> getSingleCategory(@PathVariable int catId) {
        CategoryDto categoryById = this.categoryService.getCategoryById(catId);
        return new ResponseEntity<>(categoryById, HttpStatus.OK);
    }

    @GetMapping("/get-all-category")
    public ResponseEntity<?> getAllCategory() {
        List<CategoryDto> allCategory = this.categoryService.getAllCategory();
        return new ResponseEntity<>(allCategory, HttpStatus.OK);

    }

    @PutMapping("/update-category-by-id/{catId}")
    public ResponseEntity<?> updateCategoryById(@RequestBody CategoryDto categoryDto, @PathVariable int catId) {
        CategoryDto updatedCategoryDto = this.categoryService.updateCategoryById(categoryDto, catId);
        return new ResponseEntity<>(updatedCategoryDto, HttpStatus.OK);
    }

}
