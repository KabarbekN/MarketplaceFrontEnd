package kz.itstep.client2.resources;


import kz.itstep.client2.model.Product;
import kz.itstep.client2.rest.RestProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product/{productId}")
@RequiredArgsConstructor
public class ProductResource {
    @ModelAttribute("updatedProduct")
    public Product getProductById(@PathVariable Long productId){
        return restProductClient.getProductById(productId);
    }

    private final RestProductClient restProductClient;

    @GetMapping
    public String updateProductPage(@ModelAttribute("updatedProduct") @PathVariable Long productId){
        return "/product/create-product";
    }

    @PutMapping
    public Product updateProduct(@PathVariable Long productId, @RequestBody Product product){
        return restProductClient.updateProduct(productId, product);
    }

    @GetMapping("/details")
    public String getProductDetailsPageById(@PathVariable Long productId, Model model){
        model.addAttribute("product", restProductClient.getProductById(productId));
        return "product/details";
    }


    @DeleteMapping
    public String deleteProductById(@PathVariable Long productId){
        restProductClient.deleteProduct(productId);
        return "redirect:/products/";
    }
}
