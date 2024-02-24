package com.springbootsecurityrevesion.Repo;

import com.springbootsecurityrevesion.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
        
}
