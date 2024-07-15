package kz.itstep.client2.rest;

import kz.itstep.client2.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
public class RestProductClient {
    private static final ParameterizedTypeReference<List<Product>> PRODUCTS_TYPE_REFERENCE =
            new ParameterizedTypeReference<>() {
            };

    private final RestClient restClient;
    public List<Product> getAllProducts() {
        return restClient.get()
                .uri("/product/")
                .retrieve()
                .body(PRODUCTS_TYPE_REFERENCE);
    }

    public Product getProductById(Long productId) {
        return restClient.get()
                .uri("/product/{productId}", productId)
                .retrieve()
                .body(Product.class);
    }

    public Product createProduct(Product product) {
        return restClient.post()
                .uri("/product/")
                .body(product)
                .retrieve()
                .body(Product.class);
    }
    public Product updateProduct(Long productId, Product product) {
        return restClient.put()
                .uri("/product/{id}", productId)
                .body(product)
                .retrieve()
                .body(Product.class);
    }

    public void deleteProduct(Long productId) {
        restClient.delete().uri("/product/{productId}", productId)
                .retrieve();
    }

}
