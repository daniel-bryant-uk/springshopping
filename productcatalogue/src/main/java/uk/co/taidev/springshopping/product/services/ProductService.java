package uk.co.taidev.springshopping.product.services;

import uk.co.taidev.springshopping.product.model.Product;

import java.util.*;

public class ProductService {
    private Map<String, Product> fakeProductDAO = new HashMap<>();

    public ProductService() {
        fakeProductDAO.put("1", new Product(1, "Widget"));
        fakeProductDAO.put("2", new Product(2, "Blob"));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(fakeProductDAO.values());
    }

    public Optional<Product> getProduct(String id) {
        return Optional.ofNullable(fakeProductDAO.get(id));
    }
}
