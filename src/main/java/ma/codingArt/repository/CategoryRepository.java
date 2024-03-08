package ma.codingArt.repository;

import java.awt.print.Pageable;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.codingArt.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
	Page<Category> findByIsEnabledTrue(Pageable pageable);

}
