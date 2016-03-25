package uk.co.taidev.springshopping.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uk.co.taidev.springshopping.exceptions.StockNotFoundException;
import uk.co.taidev.springshopping.model.Stock;
import uk.co.taidev.springshopping.services.StockService;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockResource {

    @Autowired
    private StockService stockService;

    @RequestMapping()
    public List<Stock> getStocks() {
        return stockService.getStocks();
    }

    @RequestMapping("{productId}")
    public Stock getStock(@PathVariable("productId") String productId) throws StockNotFoundException {
        return stockService.getStock(productId);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleStockNotFound(StockNotFoundException snfe) {
    }
}
