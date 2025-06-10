package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Dog;
import com.example.demo.service.DogService;

@Controller
@RequestMapping("/api/dogs")
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

    @GetMapping("/dogs/{id}")
    public Object getDogById(@PathVariable long id, Model model) {
        model.addAttribute("dog", dogService.getDogById(id));
        model.addAttribute("title", "Dog #: " + id);
        return "dog-details";
    }

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
    public Object showUpdateForm(@PathVariable Long id, Model model) {
        Dog dog = dogService.getDogById(id);
        model.addAttribute("dog", dog);
        model.addAttribute("title", "Update Dog: " + id);
        return "dog-update";
    }

    // Handle form submit to update a dog
    @PostMapping("/dogs/update/{id}")
    public Object updateDog(@PathVariable Long id, Dog dog) {
        dogService.updateDog(id, dog);
        return "redirect:/dogs/" + id;
    }

    // Delete a dog by ID
    @GetMapping("/dogs/delete/{id}")
    public Object deleteDog(@PathVariable Long id) {
        dogService.deleteDog(id);
        return "redirect:/dogs";
    }

    @PostMapping("/dogs/writeFile")
    public Object writeJson(@RequestBody Dog dog) {
        return dogService.writeJson(dog);
    }

    @GetMapping("/dogs/readFile")
    public Object readJson() {
        return dogService.readJson();
    }
}
