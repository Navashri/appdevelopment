package com.nextax.nextax.repository;

import com.nextax.nextax.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxRepository extends JpaRepository<Tax, Long> {
    
}