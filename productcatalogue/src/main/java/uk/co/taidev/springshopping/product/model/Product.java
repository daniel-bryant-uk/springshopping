package uk.co.taidev.springshopping.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    private long id;

    private String content;

    public Product() {
        // Jackson deserialization
    }

    public Product(long id, String content) {
        this.id = id;
        this.content = content;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }
}
