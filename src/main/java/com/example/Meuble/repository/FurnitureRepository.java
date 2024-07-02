package com.example.Meuble.repository;

import com.example.Meuble.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<Furniture, Integer> {
}
