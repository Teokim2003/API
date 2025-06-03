package com.example.demo.controller;

import com.example.demo.entity.Dog;
import com.example.demo.service.DogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dogs")
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public List<Dog> getAllDogs() {
        return dogService.getAllDogs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable Long id) {
        return dogService.getDogById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Dog addDog(@RequestBody Dog dog) {
        return dogService.addDog(dog);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dog> updateDog(@PathVariable Long id, @RequestBody Dog dog) {
        Dog updated = dogService.updateDog(id, dog);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDog(@PathVariable Long id) {
        dogService.deleteDog(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/category/{category}")
    public List<Dog> getDogsByCategory(@PathVariable String category) {
        return dogService.getDogsByCategory(category);
    }

    @GetMapping("/search")
    public List<Dog> searchDogsByName(@RequestParam String name) {
        return dogService.searchDogsByName(name);
    }
}
