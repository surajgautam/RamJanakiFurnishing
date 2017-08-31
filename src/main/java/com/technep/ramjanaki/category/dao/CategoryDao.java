package com.technep.ramjanaki.category.dao;

import com.technep.ramjanaki.category.model.Category;

import java.util.List;

/**
 * Created by surajgautam on 6/25/17.
 */
public interface CategoryDao {

    List<Category> getActiveCategories();
    List<Category> getAllCategories();
    Category getCategoryById(int id);
    boolean addCategory(Category category);
    void updateCategory(Category category);
    void deleteCategory(int id);

}
