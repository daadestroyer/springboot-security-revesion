package com.springbootsecurityrevesion.Service;

import com.springbootsecurityrevesion.Dto.CategoryDto;
import com.springbootsecurityrevesion.Repo.CategoryRepo;
import com.springbootsecurityrevesion.Model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    public CategoryDto saveCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        Category save = this.categoryRepo.save(category);
        if (save != null) {
            return this.modelMapper.map(category, CategoryDto.class);
        } else {
            return null;
        }
    }

    public List<CategoryDto> getAllCategory() {
        List<Category> categoryList = this.categoryRepo.findAll();
        List<CategoryDto> categoryDtoList = categoryList.stream().map(cat -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
        return categoryDtoList;
    }

    public CategoryDto getCategoryById(int catId) {
        Optional<Category> byId = this.categoryRepo.findById(catId);
        if (byId.isPresent()) {
            Category category = byId.get();
            return this.modelMapper.map(category, CategoryDto.class);
        }
        return null;
    }

    public CategoryDto updateCategoryById(CategoryDto categoryDto, int catId) {
        Optional<Category> byId = this.categoryRepo.findById(catId);
        if (byId.isPresent()) {
            Category savedCategory = byId.get();
            savedCategory.setCatTitle(categoryDto.getCatTitle());
            savedCategory.setCatDesc(categoryDto.getCatDesc());
            Category updatedCategory = this.categoryRepo.save(savedCategory);
            return this.modelMapper.map(updatedCategory, CategoryDto.class);
        }
        return null;
    }
}
