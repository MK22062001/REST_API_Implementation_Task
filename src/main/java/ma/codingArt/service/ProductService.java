package ma.codingArt.service;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import ma.codingArt.dto.ProductDTO;
import ma.codingArt.entity.Product;
import ma.codingArt.repository.ProductRepository;
import ma.codingArt.repository.CategoryRepository;

@Service
public class ProductService {
	 @Autowired
	 private ProductRepository productRepository;
	 @Autowired
	 private CategoryRepository categoryRepository;

	    public Page<Product> getAllProducts(Pageable pageable) {
	        return productRepository.findByIsEnabledTrue(pageable);
	    }

	    public Product getProductById(UUID id) {
	        return productRepository.findById(id)
	                .orElseThrow();
	    }

	    public Product createProduct(ProductDTO productDTO) {
	        Product product = new Product();
	        product.setTitle(productDTO.getTitle());
	        product.setDescription(productDTO.getDescription());
	        product.setCategory(categoryRepository.getOne(productDTO.getCategoryId()));
	        product.setPrice(productDTO.getPrice());
	        return productRepository.save(product);
	    }

	    public Product updateProduct(UUID id, ProductDTO productDTO) {
	        Product product = getProductById(id);
	        if (productDTO.getTitle() != null) {
	            product.setTitle(productDTO.getTitle());
	        }
	        if (productDTO.getDescription() != null) {
	            product.setDescription(productDTO.getDescription());
	        }
	        if (productDTO.getCategoryId() != null) {
	            product.setCategory(categoryRepository.getOne(productDTO.getCategoryId()));
	        }
	        if (productDTO.getPrice() != null) {
	            product.setPrice(productDTO.getPrice());
	        }
	        product.setUpdatedAt(LocalDateTime.now());
	        return productRepository.save(product);
	    }

	    public void deleteProduct(UUID id) {
	        Product product = getProductById(id);
	        productRepository.delete(product);
	    }
}
