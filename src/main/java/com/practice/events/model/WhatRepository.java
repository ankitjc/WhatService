package com.practice.events.model;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WhatRepository extends JpaRepository<Abbreviation, Integer> {

    String GET_LEADERBOARD =
            "SELECT a.addedBy, count(a.id) as abbrCount FROM abbreviation a " +
                    "WHERE isDeleted = false " +
                    "GROUP BY addedBy " +
                    "ORDER BY abbrCount desc";

    Page<Abbreviation> findAll(Pageable pageable);

    Page<Abbreviation> findByShortForm(String abbr, Pageable pageable);

    @Transactional
    default void updateOrInsert(Abbreviation entity) {
        save(entity);
    }

    @Query(value = GET_LEADERBOARD, nativeQuery = true)
    List<Object[]> getLeaderboard();

}