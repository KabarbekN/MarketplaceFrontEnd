package kz.itstep.client2.resources;

import kz.itstep.client2.model.Product;
import kz.itstep.client2.rest.RestProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsResource {
    private final RestProductClient restProductClient;


    @GetMapping("/")
    public String getAllProductsPage(Model model){
        model.addAttribute("products", restProductClient.getAllProducts());
        return "product/products";
    }


    @GetMapping("/create-product")
    public String createProductPage(Model model){
        model.addAttribute("product", new Product());
        return "product/create-product";
    }

    @PostMapping("/create-product")
    public String createProduct(@ModelAttribute("product") Product product){
        restProductClient.createProduct(product);
        return "redirect:";
    }


}
