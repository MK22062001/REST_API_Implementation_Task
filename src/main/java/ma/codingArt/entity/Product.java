package ma.codingArt.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "products")
@Data
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
    private ma.codingArt.entity.Category category; // Importez la classe Category correcte
   
    @Column(nullable = false)
    private BigDecimal price;
   
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
   
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
   
    @Column(name = "is_enabled", nullable = false)
    private boolean isEnabled = true;
}
