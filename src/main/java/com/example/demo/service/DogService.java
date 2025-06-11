package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Dog;
import com.example.demo.repository.DogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DogService {

    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }

    public Optional<Dog> getDogById(Long dogId) {
        return dogRepository.findById(dogId);
    }

    public Dog addDog(Dog dog) {
        return dogRepository.save(dog);
    }

    public Dog updateDog(Long dogId, Dog updatedDog) {
        return dogRepository.findById(dogId).map(dog -> {
            dog.setName(updatedDog.getName());
            dog.setDesc(updatedDog.getDesc());
            dog.setOtherNames(updatedDog.getOtherNames());
            dog.setOrigin(updatedDog.getOrigin());
            return dogRepository.save(dog);
        }).orElse(null);
    }

    public void deleteDog(Long dogId) {
        dogRepository.deleteById(dogId);
    }

    public List<Dog> getDogsByOrigin(String origin) {
        return dogRepository.findByOrigin(origin);
    }

    public List<Dog> searchDogsByName(String name) {
        return dogRepository.findByNameContainingIgnoreCase(name);
    }

  public String writeJson(Dog dog) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      objectMapper.writeValue(new File("dogs.json"), dog);
      return "Dog written to JSON file successfully";
    } catch (IOException e) {
      e.printStackTrace();
      return "Error writing dog to JSON file";
    }
  }

  public Object readJson() {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(new File("dogs.json"), Dog.class);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
