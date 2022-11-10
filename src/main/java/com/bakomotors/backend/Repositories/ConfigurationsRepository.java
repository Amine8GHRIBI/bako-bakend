package com.bakomotors.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bakomotors.backend.Model.Category;
import com.bakomotors.backend.Model.Configurations;
@Repository

public interface ConfigurationsRepository extends JpaRepository<Configurations, Long> {
	
	    Configurations findConfigurationsById(Long id);
	    Configurations findConfigurationsByTitle(String name);
	    boolean existsByTitle(String name);

}
