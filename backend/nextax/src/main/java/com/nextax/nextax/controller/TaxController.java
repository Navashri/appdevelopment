package com.nextax.nextax.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nextax.nextax.model.Tax;
import com.nextax.nextax.service.TaxService;

@RestController
@RequestMapping("/taxes")
public class TaxController {
    @Autowired
    private TaxService taxService;

    @PostMapping
    public ResponseEntity<Tax> createTax(@RequestBody Tax tax) {
        Tax savedTax = taxService.saveTax(tax);
        return ResponseEntity.ok(savedTax);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tax> getTaxById(@PathVariable Long id) {
        Tax tax = taxService.findTaxById(id);
        if (tax != null) {
            return ResponseEntity.ok(tax);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tax> updateTax(@PathVariable Long id, @RequestBody Tax tax) {
        Tax existingTax = taxService.findTaxById(id);
        if (existingTax != null) {
            tax.setId(id);
            Tax updatedTax = taxService.saveTax(tax);
            return ResponseEntity.ok(updatedTax);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTax(@PathVariable Long id) {
        if (taxService.findTaxById(id) != null) {
            taxService.deleteTax(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}