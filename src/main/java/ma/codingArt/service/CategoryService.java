package ma.codingArt.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.codingArt.dto.CategoryDTO;
import ma.codingArt.entity.Category;
import ma.codingArt.repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(UUID id) {
        return categoryRepository.findById(id)
                .orElseThrow();
    }

    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        return categoryRepository.save(category);
    }

    public Category updateCategory(UUID id, CategoryDTO categoryDTO) {
        Category category = getCategoryById(id);
        if (categoryDTO.getName() != null) {
            category.setName(categoryDTO.getName());
        }
        if (categoryDTO.getDescription() != null) {
            category.setDescription(categoryDTO.getDescription());
        }
        category.setUpdatedAt(LocalDateTime.now());
        return categoryRepository.save(category);
    }

    public void deleteCategory(UUID id) throws Exception {
        Category category = getCategoryById(id);
        if (!category.getProducts().isEmpty()) {
            throw new Exception("Category is associated with products and cannot be deleted");
        }
        categoryRepository.delete(category);
    }

}
