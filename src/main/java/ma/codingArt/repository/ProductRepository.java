package ma.codingArt.repository;

import org.springframework.data.domain.Pageable;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.codingArt.entity.Product;

@Repository
public interface ProductRepository  extends JpaRepository<Product, UUID> {
	Page<Product> findByIsEnabledTrue(Pageable pageable);

}
