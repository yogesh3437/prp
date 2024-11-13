package com.citiustech.prp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citiustech.prp.model.Allergy;

@Repository
public interface AllergyRepository extends JpaRepository<Allergy, Long> {}