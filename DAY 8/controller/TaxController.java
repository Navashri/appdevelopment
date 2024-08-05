package com.nextax.nextax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nextax.nextax.model.Tax;
import com.nextax.nextax.service.TaxService;

@RestController
@RequestMapping("/tax")
public class TaxController {

    @Autowired
    private TaxService taxService;

    @PostMapping("/calculate")
    public void calculateTax(@RequestBody Tax tax) {
        taxService.calculateAndSaveTax(tax);
    }
}