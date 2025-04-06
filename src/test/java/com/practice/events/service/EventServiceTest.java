package com.practice.events.service;

import com.practice.events.model.Abbreviation;
import com.practice.events.model.WhatRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EventServiceTest {

    private static final WhatRepository mockRepo = mock(WhatRepository.class);

    static EventService mockService;
    static List<Abbreviation> mockResult;

    @BeforeAll
    public static void setup() {
        mockService = new EventService(mockRepo);

        //Sample data
        Date addedAt = new Date();
        Date lastAccessed = new Date();
        Abbreviation abbr1 = new Abbreviation(1, "SF1", "", "", false, "", addedAt, lastAccessed);
        Abbreviation abbr2 = new Abbreviation(2, "SF2", "", "", false, "", addedAt, lastAccessed);

        mockResult = Lists.list(abbr1, abbr2);
    }

    @Test
    void getAllAbbreviationsSortedInAscendingOrder() {
        Page<Abbreviation> pageResult = new PageImpl<>(mockResult);
        when(mockRepo.findAll((Pageable) any())).thenReturn(pageResult);
        Page<Abbreviation> actualResponse = mockService.getAllAbbreviations(1, 10, "shortForm", false);

        assertEquals(mockResult.size(), actualResponse.getTotalElements());
        assertEquals("SF1", actualResponse.getContent().get(0).getShortForm());
    }

    @Test
    void getAllAbbreviationsSortedInDescendingOrder() {
        Page<Abbreviation> pageResult = new PageImpl<>(mockResult);
        when(mockRepo.findAll((Pageable) any())).thenReturn(pageResult);
        Page<Abbreviation> actualResponse = mockService.getAllAbbreviations(1, 10, "shortForm", true);

        assertEquals(mockResult.size(), actualResponse.getTotalElements());
        assertEquals("SF2", actualResponse.getContent().get(1).getShortForm());
    }

    @Test
    void getAbbreviationsFor() {
    }

    @Test
    void getLeaderboard() {
    }

    @Test
    void updateOrInsertUsingRepository() {
    }

    @Test
    void deleteAbbreviation() {
    }
}