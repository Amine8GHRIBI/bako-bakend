package com.bakomotors.backend.Model;


import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private String fileName;
    
    private BigDecimal price;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "produit_id")
    private List<Configurations> configs;
    
    @ManyToOne
    private Category category;

}
