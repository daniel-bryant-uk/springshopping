package uk.co.taidev.springshopping.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uk.co.taidev.springshopping.exceptions.StockNotFoundException;
import uk.co.taidev.springshopping.model.Stock;
import uk.co.taidev.springshopping.services.ProductService;
import uk.co.taidev.springshopping.services.StockService;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @RequestMapping("{productId}")
    public Stock getStock(@PathVariable("productId") long productId) throws StockNotFoundException {
        return stockService.getStock(productId);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleStockNotFound(StockNotFoundException snfe) {
    }
}
