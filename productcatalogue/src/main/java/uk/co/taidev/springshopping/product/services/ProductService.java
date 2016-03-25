package uk.co.taidev.springshopping.product.services;

import uk.co.taidev.springshopping.product.model.Product;

import java.math.BigDecimal;
import java.util.*;

public class ProductService {

    //{productId, Product}
    private Map<String, Product> fakeProductDAO = new HashMap<>();

    public ProductService() {
        fakeProductDAO.put("1", new Product("1", "Widget", "Premium ACME Widgets", new BigDecimal(1.20)));
        fakeProductDAO.put("2", new Product("2", "Sprocket", "Grade B sprockets", new BigDecimal(4.10)));
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(fakeProductDAO.values());
    }

    public Optional<Product> getProduct(String id) {
        return Optional.ofNullable(fakeProductDAO.get(id));
    }
}
