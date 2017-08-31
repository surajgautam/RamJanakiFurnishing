package com.technep.ramjanaki.category.service;

import com.technep.ramjanaki.category.model.Category;

import java.util.List;

/**
 * Created by surajgautam on 6/25/17.
 */
public interface CategoryService {

    List<Category> getActiveCategories();
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    boolean addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int id);
}
