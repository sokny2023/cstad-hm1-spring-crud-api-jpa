package co.istad.mvcdemo.controller;

import co.istad.mvcdemo.dto.CategoryRequest;
import co.istad.mvcdemo.dto.CategoryResponse;
import co.istad.mvcdemo.model.Product;
import co.istad.mvcdemo.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Operation(summary = "Get all categories")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the categories",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Product.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid id supplied",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Categories not found",
                    content = @Content)
    })

    @GetMapping
    List<CategoryResponse> findCategories(){
        return categoryService.findCategories();
    }

    @GetMapping("/{id}")
    CategoryResponse findCategoryById(@PathVariable Integer id){
        return categoryService.findCategoryById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createNewCategory(@Valid @RequestBody CategoryRequest request){
        categoryService.createNewCategory(request);
    }

    @PutMapping("/{id}")
    CategoryResponse editCategoryById(@PathVariable Integer id, @Valid @RequestBody CategoryRequest request){
        return categoryService.editCategoryById(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deleteCategoryById(@PathVariable Integer id){
        categoryService.deleteCategoryById(id);
    }

}


