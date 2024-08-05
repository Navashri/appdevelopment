package com.nextax.nextax.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nextax.nextax.model.Tax;
import com.nextax.nextax.model.UserData;
import com.nextax.nextax.service.UserDataService;

@RestController
@RequestMapping("/userdata")
public class UserDataController {

    @Autowired
    private UserDataService userDataService;

    @PostMapping("/calculate")
    public void calculateTax(@RequestBody Tax tax) {
        userDataService.calculateAndSaveTax(tax);
    }

    @GetMapping("/{id}")
    public UserData getUserData(@PathVariable Long id) {
        return userDataService.getUserData(id);
    }
}