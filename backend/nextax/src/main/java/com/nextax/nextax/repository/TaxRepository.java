package com.nextax.nextax.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextax.nextax.model.Tax;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Long> {
}