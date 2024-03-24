package co.istad.mvcdemo.service;

import co.istad.mvcdemo.dto.CategoryRequest;
import co.istad.mvcdemo.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {

    void createNewCategory(CategoryRequest request);

    CategoryResponse editCategoryById(Integer id, CategoryRequest request);

    void deleteCategoryById(Integer id);

    CategoryResponse findCategoryByName(String name);

    CategoryResponse findCategoryById(Integer id);

    List<CategoryResponse> findCategories();
}
