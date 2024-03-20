package co.istad.mvcdemo.service.impl;

import co.istad.mvcdemo.dto.ProductCreateRequest;
import co.istad.mvcdemo.dto.ProductEditRequest;
import co.istad.mvcdemo.dto.ProductResponse;
import co.istad.mvcdemo.model.Product;
import co.istad.mvcdemo.service.ProductService;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final List<Product> products;
    public ProductServiceImpl(){
        products = new ArrayList<>();
        Product p1 = new Product();
        p1.setId(1);
        p1.setName("Asus ROG");
        p1.setUuid(UUID.randomUUID().toString());
        p1.setPrice(2900.0);
        p1.setQty(10);
        p1.setImportedDate(LocalDate.now());
        p1.setStatus(true);
        Product p2 = new Product();
        p2.setId(2);
        p2.setUuid(UUID.randomUUID().toString());
        p2.setName("Samsung Galaxy S24 Ultra");
        p2.setPrice(1499.0);
        p2.setQty(2);
        p2.setImportedDate(LocalDate.now());
        p2.setStatus(true);
        products.add(p1);
        products.add(p2);
    }


    @Override
    public void editProductByUuid(String uuid, ProductEditRequest request) {
        // Check UUID if exists
        long count = products.stream()
                .filter(product -> product.getUuid().equals(uuid))
                .peek(oldProduct -> {
                    oldProduct.setName(request.name());
                    oldProduct.setPrice(request.price());
                }).count();
        System.out.println("Affected row = " + count);
    }

    @Override
    public void deleteProductByUuid(String uuid) {
        products.removeIf(delete -> delete.getUuid().equals(uuid));

        //log.i
    }

    @Override
    public void createNewProduct(ProductCreateRequest request) {
        Product newProduct = new Product();
        newProduct.setName(request.name());
        newProduct.setPrice(request.price());
        newProduct.setQty(request.qty());
        newProduct.setId(products.size() + 1);
        newProduct.setUuid(UUID.randomUUID().toString());
        newProduct.setImportedDate(LocalDate.from(LocalDateTime.now()));
        newProduct.setStatus(true);
        products.add(newProduct);

    }

    @Override
    public List<ProductResponse> findProducts(String name, Boolean status) {
        return products.stream()
                .filter(product -> product.getName().toLowerCase()
                        .contains(name.toLowerCase()) && product.getStatus().equals(status))
                .map(product -> new ProductResponse(
                        product.getUuid(),
                        product.getName(),
                        product.getPrice(),
                        product.getQty()
                ))
                .toList();
    }

    @Override
    public ProductResponse findProductById(Integer id) {
        return products.stream()
                .filter(product -> product.getId().equals(id) &&
                        product.getStatus().equals(true))
                .map(product -> new ProductResponse(
                        product.getUuid(),
                        product.getName(),
                        product.getPrice(),
                        product.getQty()
                ))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public ProductResponse findProductByUuid(String uuid) {
        return products.stream()
                .filter(product -> product.getUuid().equals(uuid) &&
                        product.getStatus().equals(true))
                .map(product -> new ProductResponse(
                        product.getUuid(),
                        product.getName(),
                        product.getPrice(),
                        product.getQty()
                ))
                .findFirst()
                .orElseThrow();
    }
}
