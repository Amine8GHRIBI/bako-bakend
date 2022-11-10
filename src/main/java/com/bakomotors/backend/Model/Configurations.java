package com.bakomotors.backend.Model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name ="Confgurations")
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(
        property = "id",
        generator = ObjectIdGenerators.PropertyGenerator.class
)
public class Configurations {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   
	private String title;
	private String subtitle;
	
	@ManyToOne
	@JsonIgnore

	private Product product;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "config_id")
    private List<Type> types;
	

}
