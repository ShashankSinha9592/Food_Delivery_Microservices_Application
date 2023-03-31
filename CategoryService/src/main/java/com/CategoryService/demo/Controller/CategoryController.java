package com.CategoryService.demo.Controller;

import com.CategoryService.demo.Model.Category;
import com.CategoryService.demo.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fooddelivery/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> addCategory(Category category){

        Category savedCategory = categoryService.addCategory(category);

        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Category> updateCategory(Category category){

        Category updatedCategory = categoryService.updateCategory(category);

        return new ResponseEntity<>(updatedCategory,HttpStatus.ACCEPTED);

    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Category> removeCategory(Integer categoryId){

        Category removedCategory = categoryService.removeCategory(categoryId);

        return new ResponseEntity<>(removedCategory, HttpStatus.OK);

    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> viewCategory(Integer categoryId){

        Category category = categoryService.viewCategory(categoryId);

        return new ResponseEntity<>(category,HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Category>> viewAllCategory(){

        List<Category> categories = categoryService.viewAllCategory();

        return new ResponseEntity<>(categories,HttpStatus.OK);

    }

}