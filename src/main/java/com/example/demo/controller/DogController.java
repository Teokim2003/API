package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Dog;
import com.example.demo.service.DogService;

@Controller
public class DogController {

    @Autowired
    private DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    // Show all dogs - display dog list page
    @GetMapping("/dogs")
    public Object getAllDogs(Model model) {
        model.addAttribute("dogList", dogService.getAllDogs());
        model.addAttribute("title", "All Dogs");
        return "dog-list";  // Renders dog-list.ftlh
    }
    
    // Get dogs by their IDs
    @GetMapping("/dogs/{id}")
    public String getDogById(@PathVariable long dogId, Model model) {
        Optional<Dog> dog = dogService.getDogById(dogId);
        if (dog.isPresent()) {
            model.addAttribute("dog", dog.get());
            model.addAttribute("title", "Dog #: " + dogId);
            return "dog-details";
        } else {
            return "redirect:/dogs"; // Or show an error page
        }
    }

    // Get dogs by their names
    @GetMapping("/dogs/name")
    public Object searchDogsByName(@RequestParam String key, Model model) {
        if (key != null && !key.isEmpty()) {
            model.addAttribute("dogList", dogService.searchDogsByName(key));
            model.addAttribute("title", "Dogs By Name: " + key);
            model.addAttribute("key", key);
            return "dog-list";
        } else {
            return "redirect:/dogs";
        }
    }

    // Get dogs by their origin
    @GetMapping("/dogs/origin/{origin}")
    public Object getDogsByOrigin(@PathVariable String origin, Model model) {
        model.addAttribute("dogList", dogService.getDogsByOrigin(origin));
        model.addAttribute("title", "Dogs By Origin: " + origin);
        return "dog-list";
    }

    // Show form to create new dog
    @GetMapping("/dogs/createForm")
    public Object showCreateForm(Model model) {
        Dog dog = new Dog();
        model.addAttribute("dog", dog);
        model.addAttribute("title", "Create New Dog");
        return "dog-create";
    }

    // Handle form submit to add a new dog
    @PostMapping("/dogs")
    public Object addDog(Dog dog) {
        Dog newDog = dogService.addDog(dog);
        return "redirect:/dogs/" + newDog.getDogId();
    }

    // Show dog details or edit form
    @GetMapping("/dogs/updateForm/{id}")
    public String showUpdateForm(@PathVariable Long dogId, Model model) {
        Optional<Dog> dog = dogService.getDogById(dogId);
        if (dog.isPresent()) {
            model.addAttribute("dog", dog.get());
            model.addAttribute("title", "Update Dog: " + dogId);
            return "dog-update";
        } else {
            return "redirect:/dogs";
        }
    }

    // Handle form submit to update a dog
    @PostMapping("/dogs/update/{id}")
    public Object updateDog(@PathVariable Long dogId, Dog dog) {
        dogService.updateDog(dogId, dog);
        return "redirect:/dogs/" + dogId;
    }

    // Delete a dog by ID
    @GetMapping("/dogs/delete/{id}")
    public Object deleteDog(@PathVariable Long dogId) {
        dogService.deleteDog(dogId);
        return "redirect:/dogs";
    }

    // Write a dog to a JSON file
    @PostMapping("/students/writeFile")
    public Object writeJson(@RequestBody Dog dog) {
        dogService.writeJson(dog);
        return dogService.writeJson(dog);
    }

    // Write a dog to a JSON file
    @GetMapping("/dogs/readFile")
    public Object readJson() {
        return dogService.readJson();

    }
}
