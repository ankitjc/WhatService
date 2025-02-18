package com.practice.events.model;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WhatRepository extends JpaRepository<Abbreviations, Integer> {

    String GET_LEADERBOARD = "select addedby, count(abbreviation) as abbrAdded from abbreviations GROUP BY addedby ORDER BY abbrAdded desc";

    List<Abbreviations> findByAbbreviation(String abr);

    @Transactional
    default void updateOrInsert(Abbreviations entity) {
        save(entity);
    }

    @Query(value = GET_LEADERBOARD, nativeQuery = true)
    List<Object[]> getLeaderboard();
}