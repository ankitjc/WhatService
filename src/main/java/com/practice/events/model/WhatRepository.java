package com.practice.events.model;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhatRepository extends JpaRepository<Abbreviations, Integer> {
    List<Abbreviations> findByAbbreviation(String abr);

    @Transactional
    default void updateOrInsert(Abbreviations entity) {
        save(entity);
    }
}