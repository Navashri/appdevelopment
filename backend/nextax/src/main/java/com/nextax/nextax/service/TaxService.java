package com.nextax.nextax.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextax.nextax.model.Tax;
import com.nextax.nextax.repository.TaxRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaxService {

    @Autowired
    private TaxRepository taxRepository;

    public Tax saveTax(Tax tax) {
        return taxRepository.save(tax);
    }

    public Tax findTaxById(Long id) {
        Optional<Tax> tax = taxRepository.findById(id);
        return tax.orElse(null);
    }

    public void deleteTax(Long id) {
        taxRepository.deleteById(id);
    }

    public List<Tax> getAllTaxes() {
        return taxRepository.findAll();
    }
}