package uk.co.taidev.springshopping.product.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import uk.co.taidev.springshopping.product.exceptions.ProductNotFoundException;
import uk.co.taidev.springshopping.product.model.Product;
import uk.co.taidev.springshopping.product.services.ProductService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    private ProductService productService;

    @Inject
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GET
    @Timed
    public Response getAllProducts() {
        return Response.status(200)
                .entity(productService.getAllProducts())
                .build();
    }


    @GET
    @Timed
    @Path("{id}")
    public Response getProduct(@PathParam("id") String id) throws ProductNotFoundException {
        Optional<Product> result = productService.getProduct(id);

        if (result.isPresent()) {
            return Response.status(Response.Status.OK)
                    .entity(result.get())
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
    }
}
