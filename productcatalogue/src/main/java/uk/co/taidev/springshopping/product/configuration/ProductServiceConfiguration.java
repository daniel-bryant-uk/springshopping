package uk.co.taidev.springshopping.product.configuration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class ProductServiceConfiguration extends Configuration {

    private String serviceName;

    @JsonCreator
    public ProductServiceConfiguration(String serviceName) {
        this.serviceName = serviceName;
    }

    @JsonProperty
    public String getServiceName() {
        return serviceName;
    }

    @JsonProperty
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}