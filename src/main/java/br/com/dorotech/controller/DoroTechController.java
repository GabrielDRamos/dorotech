package br.com.dorotech.controller;

import br.com.dorotech.controller.request.ProductRequest;
import br.com.dorotech.controller.response.ProductResponse;
import br.com.dorotech.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/products")
@Data
public class DoroTechController {
    private final ProductService productService;
    private List<ProductRequest> productRequestList  = new ArrayList<ProductRequest>();;

    @PostMapping
    public String create(@RequestBody  ProductRequest productRequest) {
       this.productService.create(productRequest.createProductDomain());
        return "product created with success";
    }

    @GetMapping
    public List<ProductRequest> list() {
        return this.productRequestList;
    }

    @DeleteMapping
    public String delete() {
        return "delete product";
    }

    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id){
        return ProductResponse.builder().build()
        .toProductResponse(this.productService.getProduct(id));
    }

    @GetMapping("name/{name}")
    public ProductResponse getProductByName(@PathVariable String name){
        return ProductResponse.builder().build()
        .toProductResponse(this.productService.getProductName(name));
    }

    @GetMapping("/list")
    public List<ProductResponse> getAllProducts(){
      return this.productService.getProducts().stream()
       .map(xpto -> ProductResponse.builder().build().toProductResponse(xpto)).toList();
    }
}
