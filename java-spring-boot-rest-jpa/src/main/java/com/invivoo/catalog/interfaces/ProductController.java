package com.invivoo.catalog.interfaces;

import com.invivoo.catalog.domain.product.Product;
import com.invivoo.catalog.domain.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {


    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (!optionalProduct.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalProduct.get());
    }

    @PostMapping
    public ResponseEntity<Product> post(@RequestBody Product product) {
        productRepository.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity put(@RequestBody Product product) {
        Long productId = product.getId();
        if (productId == null || productDoesNotExistsById(productId)) {
            return ResponseEntity.notFound().build();
        }
        productRepository.save(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") Long id) {
        if (productDoesNotExistsById(id)) {
            return ResponseEntity.notFound().build();
        }
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private boolean productDoesNotExistsById(Long productId) {
        return !productRepository.existsById(productId);
    }
}
