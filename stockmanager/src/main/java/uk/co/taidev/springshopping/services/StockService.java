package uk.co.taidev.springshopping.services;

import org.springframework.stereotype.Service;
import uk.co.taidev.springshopping.exceptions.StockNotFoundException;
import uk.co.taidev.springshopping.model.Stock;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class StockService {

    //{productId, Stock}
    private Map<String, Stock> fakeStockDAO = new HashMap<>();

    public StockService() {
        fakeStockDAO.put("1", new Stock("1", "12345678", 3));
        fakeStockDAO.put("2", new Stock("2", "34567890", 0));
    }

    public Stock getStock(String productId) throws StockNotFoundException {
        return Optional.ofNullable(fakeStockDAO.get(productId))
                .orElseThrow(() -> new StockNotFoundException("Stock not found with productId: " + productId));
    }
}
