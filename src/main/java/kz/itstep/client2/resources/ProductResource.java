package kz.itstep.client2.resources;

import kz.itstep.client2.rest.RestProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductResource {
    private final RestProductClient restProductClient;

    @GetMapping("")
    public String getAllProductsPage(Model model){
        model.addAttribute("products", restProductClient.getAllProducts());
        return "product/products";
    }

    @GetMapping("/details/{id}")
    public String getProductDetailsPageById(@PathVariable Long id, Model model){
        model.addAttribute("product", restProductClient.getProductById(id));
        return "product/details";
    }

//    @GetMapping("/create-product")
//    public String createProductPage(Model model){
//        model.addAttribute("product", new Product());
//        return "product/create-product";
//    }
//
//    @PostMapping("/create-product")
//    public String createProduct(@ModelAttribute("product") Product product){
//        return "/product/products";
//    }
}
