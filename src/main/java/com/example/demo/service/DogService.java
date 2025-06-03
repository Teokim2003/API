package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Dog;
import com.example.demo.repository.DogRepository;

@Service
public class DogService {

    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    public Optional<Dog> getDogById(Long id) {
        return dogRepository.findById(id);
    }

    public Dog addDog(Dog dog) {
        return dogRepository.save(dog);
    }

    public Dog updateDog(Long id, Dog updatedDog) {
        return dogRepository.findById(id).map(dog -> {
            dog.setName(updatedDog.getName());
            dog.setDesc(updatedDog.getDesc());
            dog.setOtherNames(updatedDog.getOtherNames());
            dog.setOrigin(updatedDog.getOrigin());
            dog.setCategory(updatedDog.getCategory());
            return dogRepository.save(dog);
        }).orElse(null);
    }

    public void deleteDog(Long id) {
        dogRepository.deleteById(id);
    }

    public List<Dog> getDogsByCategory(String category) {
        return dogRepository.findByCategory(category);
    }

    public List<Dog> searchDogsByName(String name) {
        return dogRepository.findByNameContainingIgnoreCase(name);
    }
}
