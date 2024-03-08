package ma.codingArt.controller;

import java.awt.print.Pageable;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ma.codingArt.dto.ProductDTO;
import ma.codingArt.entity.Product;
import ma.codingArt.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	 @Autowired
	    private ProductService productService;

	    @GetMapping
	    public ResponseEntity<Page<Product>> getAllProducts(Pageable pageable) {
	        Page<Product> products = productService.getAllProducts(pageable);
	        return ResponseEntity.ok(products);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable UUID id) {
	        Product product = productService.getProductById(id);
	        return ResponseEntity.ok(product);
	    }

	    @PostMapping
	    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductDTO productDTO) {
	        Product product = productService.createProduct(productDTO);
	        return ResponseEntity.status(HttpStatus.CREATED).body(product);
	    }

	    @PatchMapping("/{id}")
	    public ResponseEntity<Product> updateProduct(@PathVariable UUID id, @RequestBody ProductDTO productDTO) {
	        Product product = productService.updateProduct(id, productDTO);
	        return ResponseEntity.ok(product);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
	        productService.deleteProduct(id);
	        return ResponseEntity.noContent().build();
	    }

}
