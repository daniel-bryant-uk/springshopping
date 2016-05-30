package uk.co.taidev.springshopping.repo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import uk.co.taidev.springshopping.services.dto.StockDTO;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class StockRepo {

    @Value("${location.stockManager}")
    private String stockManagerLocation;

    @Autowired
    @Qualifier(value = "stdRestTemplate")
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "stocksNotFound")
    public Map<String, StockDTO> getStockDTOs() {
        ResponseEntity<List<StockDTO>> stockManagerResponse =
                restTemplate.exchange(stockManagerLocation + "/stocks",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<StockDTO>>() {
                        });
        List<StockDTO> stockDTOs = stockManagerResponse.getBody();

        return stockDTOs.stream()
                .collect(Collectors.toMap(StockDTO::getProductId, Function.identity()));
    }

    public Map<String, StockDTO> stocksNotFound() {
        return Collections.EMPTY_MAP;
    }
}
