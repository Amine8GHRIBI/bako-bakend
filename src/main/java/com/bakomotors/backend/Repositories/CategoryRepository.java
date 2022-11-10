package com.bakomotors.backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bakomotors.backend.Model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findCategoryById(Long id);

	Category findCategoryByName(String name);

	boolean existsByName(String name);
}
