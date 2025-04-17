package com.kazungudev.spring_boot_e_commerce.services;



import com.kazungudev.spring_boot_e_commerce.dto.CategoryDto;
import com.kazungudev.spring_boot_e_commerce.repositories.ProductRepository;
import com.kazungudev.spring_boot_e_commerce.models.Category;
import com.kazungudev.spring_boot_e_commerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;


    public void create(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());

        categoryRepository.save(category);
    }

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(item -> new CategoryDto(
                        item.getId(),
                        item.getName()
                ))
                .collect(Collectors.toList());
    }

    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }

    public Category findById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            return category.get();
        } else {
            throw new RuntimeException("Category not found for id :: " + id);
        }
    }

    @Transactional
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }
}
