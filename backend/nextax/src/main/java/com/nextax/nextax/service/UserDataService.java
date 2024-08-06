package com.nextax.nextax.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextax.nextax.model.User;
import com.nextax.nextax.model.UserData;
import com.nextax.nextax.repository.UserDataRepository;
import com.nextax.nextax.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserDataService {

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private UserRepository userRepository;

    public UserData saveUserData(UserData userData) {
        // Fetch the User entity from the database
        Optional<User> userOptional = userRepository.findById(userData.getUser().getId());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userData.setUser(user);

            // Logic to calculate total and taxAmount, if needed
            userData.setTotal(calculateTotal(userData));
            userData.setTaxAmount(calculateTax(userData));

            return userDataRepository.save(userData);
        }
        throw new RuntimeException("User not found with ID: " + userData.getUser().getId());
    }

    public List<UserData> getAllUserData() {
        return userDataRepository.findAll();
    }

    public Optional<UserData> getUserDataById(Long id) {
        return userDataRepository.findById(id);
    }

    public void deleteUserData(Long id) {
        userDataRepository.deleteById(id);
    }

    private Double calculateTotal(UserData userData) {
        // Replace this with actual calculation logic if needed
        return userData.getTotal(); // Assuming total is passed in request
    }

    private Double calculateTax(UserData userData) {
        // Replace this with actual tax calculation logic if needed
        return userData.getTaxAmount(); // Assuming taxAmount is passed in request
    }
}