package com.practice.events.model;

import com.practice.events.model.Abbreviations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhatRepository extends JpaRepository<Abbreviations, Integer> {
}