package com.cos.petproject.domain.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
	
	@Query(value = "select * from animal where animalId = :animalId", nativeQuery = true)
	Animal mFindById(int animalId);

}

