package uk.co.taidev.springshopping.model;

public class Stock {

    private long productId;
    private String sku;
    private int amountAvailable;

    public Stock(long productId, String sku, int amountAvailable) {
        this.productId = productId;
        this.sku = sku;
        this.amountAvailable = amountAvailable;
    }

    public long getProductId() {
        return productId;
    }

    public String getSku() {
        return sku;
    }

    public int getAmountAvailable() {
        return amountAvailable;
    }
}
