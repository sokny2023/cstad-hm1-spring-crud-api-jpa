package co.istad.mvcdemo.service.impl;

import co.istad.mvcdemo.dto.CategoryRequest;
import co.istad.mvcdemo.dto.CategoryResponse;
import co.istad.mvcdemo.model.Category;
import co.istad.mvcdemo.repository.CategoryRepository;
import co.istad.mvcdemo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void createNewCategory(CategoryRequest request) {

    }

    @Override
    public CategoryResponse editCategoryById(Integer id, CategoryRequest request) {
        return null;
    }

    @Override
    public void deleteCategoryById(Integer id) {

    }

    @Override
    public CategoryResponse findCategoryByName(String name) {

        return null;
    }

    @Override
    public CategoryResponse findCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category has been not found"
                ));
        return new CategoryResponse(category.getName(),category.getDescription());
    }

    @Override
    public List<CategoryResponse> findCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category ->
                        new CategoryResponse(category.getName(),category.getDescription()))
                .toList();
    }

}
