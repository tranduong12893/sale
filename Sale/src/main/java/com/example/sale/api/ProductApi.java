package com.example.sale.api;

import com.example.sale.entity.Product;
import com.example.sale.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/products")
@CrossOrigin(value = "*")

public class ProductApi {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Product> findAll(){
        return productRepository.findAll();
    }

    @RequestMapping(path = "{id}", method = RequestMethod.GET)
    public Product findById(@PathVariable UUID id) {
        Optional<Product> optionalProduct = productRepository.findById(String.valueOf(id));
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody Product product){
        productRepository.save(product);
        return product;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.DELETE)
    public boolean deleteById(@PathVariable UUID id){
        Optional<Product> optionalProduct = productRepository.findById(String.valueOf(id));
        if(optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            productRepository.delete(product);
        }
        return false;
    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public Product updateById(@RequestBody Product updateProduct, @PathVariable UUID id){
        Optional<Product> optionalProduct = productRepository.findById(String.valueOf(id));
        if(optionalProduct.isPresent()){
            Product existingProduct = optionalProduct.get();
            existingProduct.setProdName(updateProduct.getProdName());
            existingProduct.setPrice(updateProduct.getPrice());
            existingProduct.setDescription(updateProduct.getDescription());
            existingProduct.setCreatedBy(updateProduct.getCreatedBy());
            existingProduct.setUpdatedBy(updateProduct.getUpdatedBy());
            existingProduct.setDeletedBy(updateProduct.getDeletedBy());
            productRepository.save(existingProduct);
        }
        return null;
    }
}
