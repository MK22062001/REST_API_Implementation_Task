package ma.codingArt.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Locale.Category;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
   
    @Column(unique = true, nullable = false)
    private UUID uuid = UUID.randomUUID();
   
    @Column(nullable = false)
    private String title;
   
    @Column
    private String description;
   
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
   
    @Column(nullable = false)
    private BigDecimal price;
   
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
   
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
   
    @Column(name = "is_enabled", nullable = false)
    private boolean isEnabled = true;

	public void setCategory(ma.codingArt.entity.Category one) {
		// TODO Auto-generated method stub
		
	}

}
