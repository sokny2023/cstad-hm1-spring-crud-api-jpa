package co.istad.mvcdemo.controller;

import co.istad.mvcdemo.dto.ProductCreateRequest;
import co.istad.mvcdemo.dto.ProductEditRequest;
import co.istad.mvcdemo.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    ResponseEntity<?> findProducts(@RequestParam(required = false, defaultValue = "") String name,
                                   @RequestParam(required = false, defaultValue = "true") Boolean status) {
        Map<String, Object> data = Map.of(
                "message", "Products have been found",
                "data", productService.findProducts(name, status));
        //return new ResponseEntity<>(data, HttpStatus.ACCEPTED);
        return ResponseEntity.accepted().body(data);
    }


    @PutMapping("/{uuid}")
    void editProductByUuid(@PathVariable String uuid,
                           @RequestBody ProductEditRequest request) {
        productService.editProductByUuid(uuid, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{uuid}")
    void deleteProductByUuid(@PathVariable String uuid){
        productService.deleteProductByUuid(uuid);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void createNewProduct(@Valid @RequestBody ProductCreateRequest request) {
        System.out.println("REQUEST: " + request);
        productService.createNewProduct(request);
    }

    @GetMapping("/{id}")
    Map<String, Object> findProductById(@PathVariable Integer id) {
        return Map.of(
                "message", "Product has been found",
                "data", productService.findProductById(id)
        );
    }

    @GetMapping("/uuid/{uuid}")
    Map<String, Object> findProductByUuid(@PathVariable String uuid) {
        return Map.of(
                "message", "Product has been found",
                "data", productService.findProductByUuid(uuid)
        );
    }

}
