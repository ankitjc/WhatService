package com.practice.events.controller;

import com.practice.events.model.Abbreviation;
import com.practice.events.service.EventService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.stubbing.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EventsControllerTest {
    private final EventService mockEventService = mock(EventService.class);

    private final EventsController _controller = new EventsController(mockEventService);

    @Test
    void fetchAllAbbr() {
        //Sample data
        Abbreviation abbr1 = new Abbreviation();
        Abbreviation abbr2 = new Abbreviation();
        List<Abbreviation> mockedAbbreviations = Arrays.asList(abbr1, abbr2);

        //Mocking Page
        Page<Abbreviation> pageMock = new PageImpl<>(mockedAbbreviations);
        when(mockEventService.getAllAbbreviations(anyInt(), anyInt(), anyString(), anyBoolean())).thenReturn(pageMock);

        Page<Abbreviation> response = mockEventService.getAllAbbreviations( 1, 10, "", true);
        assertEquals(response.getTotalElements(), mockedAbbreviations.size());
    }

    @Test
    void fetchAbbr() {
    }

    @Test
    void addOrUpdateAbbreviation() {
    }

    @Test
    void deleteAbbreviation() {
    }

    @Test
    void getLeaderboard() {
    }

    @Test
    void whenCalledCheckThenGetResponse() {
        String expectedResponse = "Connection Successful";
        String actualResponse = _controller.check();
        assertEquals(expectedResponse, actualResponse);
    }
}