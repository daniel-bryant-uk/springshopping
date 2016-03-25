package uk.co.taidev.springshopping.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.co.taidev.springshopping.model.Product;
import uk.co.taidev.springshopping.services.dto.ProductDTO;
import uk.co.taidev.springshopping.services.dto.StockDTO;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private static final String PRODUCT_CATALOGUE_LOCATION = "http://localhost:9010";
    private static final String STOCK_MANAGER_LOCATION = "http://localhost:8090";

    @Autowired
    private RestTemplate restTemplate;

    public List<Product> getProducts() {
        Map<String, ProductDTO> productDTOs = getProductDTOs();
        Map<String, StockDTO> stockDTOMap = getStockDTOs();

        // Merge productDTOs and stockDTOs to a List of Products
        return productDTOs.values().stream()
                .map(productDTO -> {
                    StockDTO stockDTO = stockDTOMap.get(productDTO.getId());
                    return new Product(productDTO.getId(), stockDTO.getSku(), productDTO.getName(), productDTO.getDescription(), productDTO.getPrice(), stockDTO.getAmountAvailable());
                })
                .collect(Collectors.toList());
    }

    private Map<String, ProductDTO> getProductDTOs() {
        ResponseEntity<List<ProductDTO>> productCatalogueResponse =
                restTemplate.exchange(PRODUCT_CATALOGUE_LOCATION + "/products",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<ProductDTO>>() {
                        });
        List<ProductDTO> productDTOs = productCatalogueResponse.getBody();

        return productDTOs.stream()
                .collect(Collectors.toMap(ProductDTO::getId, Function.identity()));
    }

    private Map<String, StockDTO> getStockDTOs() {
        ResponseEntity<List<StockDTO>> stockManagerResponse =
                restTemplate.exchange(STOCK_MANAGER_LOCATION + "/stocks",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<StockDTO>>() {
                        });
        List<StockDTO> stockDTOs = stockManagerResponse.getBody();

        return stockDTOs.stream()
                .collect(Collectors.toMap(StockDTO::getProductId, Function.identity()));
    }
}
