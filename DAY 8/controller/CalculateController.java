package com.nextax.nextax.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nextax.nextax.model.Tax;
import com.nextax.nextax.service.UserDataService;

@RestController
@RequestMapping("/calculate")
public class CalculateController {

    @Autowired
    private UserDataService userDataService;

    @PostMapping
    public void calculateTax(@RequestBody Tax tax) {
        userDataService.calculateAndSaveTax(tax);
    }
}