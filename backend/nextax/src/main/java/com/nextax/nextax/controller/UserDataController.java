package com.nextax.nextax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nextax.nextax.model.UserData;
import com.nextax.nextax.service.UserDataService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userdata")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @PostMapping
    public ResponseEntity<UserData> createUserData(@RequestBody UserData userData) {
        try {
            UserData savedUserData = userDataService.saveUserData(userData);
            return ResponseEntity.ok(savedUserData);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<UserData>> getAllUserData() {
        List<UserData> userDataList = userDataService.getAllUserData();
        return ResponseEntity.ok(userDataList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserData> getUserDataById(@PathVariable Long id) {
        Optional<UserData> userData = userDataService.getUserDataById(id);
        return userData.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserData> updateUserData(@PathVariable Long id, @RequestBody UserData userData) {
        Optional<UserData> existingUserData = userDataService.getUserDataById(id);
        if (existingUserData.isPresent()) {
            userData.setId(id);
            UserData updatedUserData = userDataService.saveUserData(userData);
            return ResponseEntity.ok(updatedUserData);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserData(@PathVariable Long id) {
        if (userDataService.getUserDataById(id).isPresent()) {
            userDataService.deleteUserData(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}