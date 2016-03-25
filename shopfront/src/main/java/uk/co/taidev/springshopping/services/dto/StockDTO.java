package uk.co.taidev.springshopping.services.dto;

public class StockDTO {
    private String productId;
    private String sku;
    private int amountAvailable;

    public StockDTO() {
    }

    public StockDTO(String productId, String sku, int amountAvailable) {
        this.productId = productId;
        this.sku = sku;
        this.amountAvailable = amountAvailable;
    }

    public String getProductId() {
        return productId;
    }

    public String getSku() {
        return sku;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }
}
