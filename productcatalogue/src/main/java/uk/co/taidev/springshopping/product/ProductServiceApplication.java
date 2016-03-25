package uk.co.taidev.springshopping.product;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import uk.co.taidev.springshopping.product.configuration.ProductServiceConfiguration;
import uk.co.taidev.springshopping.product.resources.ProductResource;

public class ProductServiceApplication extends Application<ProductServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new ProductServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "product-list-service";
    }

    @Override
    public void initialize(Bootstrap<ProductServiceConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(ProductServiceConfiguration configuration,
                    Environment environment) {
        //di with guice
        Injector injector = Guice.createInjector();
        environment.jersey().register(injector.getInstance(ProductResource.class));
    }

}