package com.bakomotors.backend.Model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor

public class Type {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
	private String description;
	private BigDecimal price;
	
	@ManyToOne
	@JsonIgnore

	private Configurations config;
	
}
