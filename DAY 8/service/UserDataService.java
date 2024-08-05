package com.nextax.nextax.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextax.nextax.model.Tax;
import com.nextax.nextax.model.UserData;
import com.nextax.nextax.repository.TaxRepository;
import com.nextax.nextax.repository.UserDataRepository;

@Service
public class UserDataService {

    @Autowired
    private UserDataRepository userDataRepository;

    @Autowired
    private TaxRepository taxRepository;

    public void calculateAndSaveTax(Tax tax) {
        Double total = tax.getTotal();
        Double taxAmount = tax.getTax();

        UserData userData = new UserData();
        userData.setTax(tax);
        userData.setTotal(total);
        userData.setTaxAmount(taxAmount);

        tax.setUserData(userData);

        taxRepository.save(tax);
        userDataRepository.save(userData);
    }

    public UserData getUserData(Long id) {
        return userDataRepository.findById(id).orElse(null);
    }
}