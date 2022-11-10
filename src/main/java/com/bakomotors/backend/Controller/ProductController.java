package com.bakomotors.backend.Controller;


import com.bakomotors.backend.Model.Product;
import com.bakomotors.backend.Services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController()
@RequestMapping("/products")
@RequiredArgsConstructor()
public class ProductController {

    private final ProductService productService;
   // private final AmazonS3BucketService amazonS3BucketService;

    @PostMapping(path = "", consumes = "multipart/form-data")
    public String saveProduct(@RequestParam("product") String data, @RequestPart("file") MultipartFile file) throws IOException {

        Product product = new ObjectMapper().readValue(data, Product.class);
        productService.save(product);
     //   return this.amazonS3BucketService.uploadFile(file);
		return data;
    }

    @GetMapping(path = "/categories/{category}")
    public List<Product> getAllProductsByCategoryName(@PathVariable(value="category") String category){
        return productService.findAllByCategoryName(category);
    }

    @GetMapping(path = "/{id}")
    public Product getProductById(@RequestParam(value="id") Long id){
        return productService.findProductById(id);
    }

    @GetMapping(path = "", params = "name")
    public Boolean isProductExists(@RequestParam(value="name") String name){
        return productService.existsByName(name);
    }

    @GetMapping(path = "")
    public List<Product> getAllProducts(){
        return productService.findAll();
    }
    @PutMapping(path = "/{id}", consumes = "multipart/form-data")
    public void updateProduct(@RequestParam("product") String data, @RequestBody MultipartFile file) throws IOException {
        Product product  = new ObjectMapper().readValue(data, Product.class);

        if(file != null){
          //  amazonS3BucketService.uploadFile(file);
        }
        productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable("id") Long id){
        Product product = productService.findProductById(id);
       // amazonS3BucketService.deleteFileFromBucket(product.getFileName());
        productService.delete(product);
    }
}
