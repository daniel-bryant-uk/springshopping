package uk.co.taidev.springshopping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.co.taidev.springshopping.model.Product;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;

    public List<Product> getProducts() {
        return Collections.singletonList(new Product("1", "Widget", "ACME grade A widget", new BigDecimal(1.2)));
    }

}
