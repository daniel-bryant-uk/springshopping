package uk.co.taidev.springshopping.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import uk.co.taidev.springshopping.services.dto.ProductDTO;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class ProductRepo {

    private static final String PRODUCT_CATALOGUE_LOCATION = "http://localhost:9010";

    @Autowired
    @Qualifier(value = "stdRestTemplate")
    private RestTemplate restTemplate;


    public Map<String, ProductDTO> getProductDTOs() {
        ResponseEntity<List<ProductDTO>> productCatalogueResponse =
                restTemplate.exchange(PRODUCT_CATALOGUE_LOCATION + "/products",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductDTO>>() {
                        });
        List<ProductDTO> productDTOs = productCatalogueResponse.getBody();

        return productDTOs.stream()
                .collect(Collectors.toMap(ProductDTO::getId, Function.identity()));
    }
}
