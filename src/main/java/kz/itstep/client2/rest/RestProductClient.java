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

}
