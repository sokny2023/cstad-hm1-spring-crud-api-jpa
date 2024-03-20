package co.istad.mvcdemo.service;

import co.istad.mvcdemo.dto.ProductCreateRequest;
import co.istad.mvcdemo.dto.ProductDto;
import co.istad.mvcdemo.dto.ProductEditRequest;
import co.istad.mvcdemo.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    void editProductByUuid(String uuid, ProductEditRequest request);

    void deleteProductByUuid(String uuid);

    void createNewProduct(ProductCreateRequest request);

    List<ProductResponse> findProducts(String name, Boolean status);

    ProductResponse findProductById(Integer id);

    ProductResponse findProductByUuid(String uuid);

}
