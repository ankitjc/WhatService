package com.practice.events.model;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WhatRepository extends JpaRepository<Abbreviation, Integer> {

    String GET_LEADERBOARD =
            "SELECT a.addedBy, count(a.id) as abbrCount FROM abbreviation a " +
                    "WHERE isDeleted = false " +
                    "GROUP BY addedBy " +
                    "ORDER BY abbrCount desc";

    String UPDATE_ABBREVIATION_WITH_VALUE =
            "UPDATE abbreviation a " +
                    "SET a.description=?1 " +
                    "WHERE a.shortForm=?2";

    List<Abbreviation> findByShortForm(String abr);

    @Transactional
    default void updateOrInsert(Abbreviation entity) {
        save(entity);
    }

    @Query(value = GET_LEADERBOARD, nativeQuery = true)
    List<Object[]> getLeaderboard();

}