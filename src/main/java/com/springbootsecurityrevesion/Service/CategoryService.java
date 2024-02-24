package com.springbootsecurityrevesion.Service;
import com.springbootsecurityrevesion.Dto.CategoryDto;
import com.springbootsecurityrevesion.Repo.CategoryRepo;
import com.springbootsecurityrevesion.Model.Category;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    public CategoryDto saveCategory(CategoryDto categoryDto){
        Category category = this.modelMapper.map(categoryDto, Category.class);
        Category save = this.categoryRepo.save(category);
        if(save!=null){
            return this.modelMapper.map(category,CategoryDto.class);
        }
        else{
            return null;
        }
    }
}
