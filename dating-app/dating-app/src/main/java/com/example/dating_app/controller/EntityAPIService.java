package com.example.dating_app.controller;

import com.example.dating_app.model.Entity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/entity")
public class EntityAPIService {

    // A List to simulate a collection of users
    private static final List<Entity> users = new ArrayList<>();

    static {
        // Adding some dummy data to the list
        users.add(new Entity("user1", "female", 25, new String[]{"Cricket", "Chess"}));
        users.add(new Entity("user2", "male", 27, new String[]{"Cricket", "Football", "Movies"}));
        users.add(new Entity("user3", "male", 26, new String[]{"Movies", "Tennis", "Football", "Cricket"}));
        users.add(new Entity("user4", "female", 24, new String[]{"Tennis", "Football", "Badminton"}));
        users.add(new Entity("user5", "female", 32, new String[]{"Cricket", "Football", "Movies", "Badminton"}));
    }


    @GetMapping("/{name}")
    public List<Entity> getEntitiesByNameWithGenderAndInterests(@PathVariable String name) {
        // Find the user by the provided name
        Entity user = users.stream()
                .filter(u -> u.getName().equalsIgnoreCase(name))  // Filter by name (case-insensitive)
                .findFirst()
                .orElse(null);  // Return null if no user is found

        // If user is not found, return an empty list
        if (user == null) {
            return new ArrayList<>();
        }

        // Get the age, gender, and interests of the found user
        int ageToCompare = user.getAge();
        String oppositeGender = user.getGender().equalsIgnoreCase("male") ? "female" : "male";
        String[] userInterests = user.getInterests();

        // Filter users whose age is less than the found user's age, opposite gender, and shares interests
        return users.stream()
                .filter(u -> u.getAge() < ageToCompare)  // Filter by age
                .filter(u -> u.getGender().equalsIgnoreCase(oppositeGender))  // Filter by opposite gender
                .filter(u -> Arrays.stream(u.getInterests()).anyMatch(interest -> Arrays.asList(userInterests).contains(interest)))  // Filter by shared interests
                .collect(Collectors.toList());  // Return the list of matching users
    }


    // This method will fetch a specific user by their name
//    @GetMapping("/{name}")
//    public Entity getEntityByName(@PathVariable String name) {
//        return users.stream()
//                .filter(user -> user.getName().equals(name))
//                .findFirst()
//                .orElse(null); // Return null if no user is found
//    }

    // This method will return all users
//    @GetMapping("/{age}")
//    public Entity getEntityByAge(@PathVariable int age) {
//        return users.stream()
//                .filter(user -> user.getAge() == age)
//                .findFirst()
//                .orElse(null); // Return null if no user is found
//    }
}
