package com.practice.events.service;

import com.practice.events.model.Abbreviation;
import com.practice.events.model.WhatRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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
        Abbreviation abbr1 = new Abbreviation(1, "", "", "", false, "", addedAt, lastAccessed);
        Abbreviation abbr2 = new Abbreviation();

        mockResult = Lists.list(abbr1, abbr2);
    }

    @Test
    void getAllAbbreviations() {
        when(mockRepo.findAll()).thenReturn(mockResult);

        Page<Abbreviation> actualResponse = mockService.getAllAbbreviations(1, 10, "", false);

        assertEquals(mockResult.size(), actualResponse.getTotalElements());
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