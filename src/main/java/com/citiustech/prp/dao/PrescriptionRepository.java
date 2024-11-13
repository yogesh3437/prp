package com.citiustech.prp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.citiustech.prp.model.Prescription;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {}