package com.example.demo.repository;

import com.example.demo.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
    List<Dog> findByOrigin(String origin);
    List<Dog> findByNameContainingIgnoreCase(String name);
}
