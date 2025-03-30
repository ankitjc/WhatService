package com.practice.events.controller;

import com.practice.events.model.Abbreviation;
import com.practice.events.service.EventService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EventsControllerTest {
    private final EventService mockEventService = mock(EventService.class);

    private final EventsController _controller = new EventsController(mockEventService);
    private static List<Abbreviation> mockedAbbreviations;

    @BeforeAll
    static void setup() {
        //Sample data
        Date addedAt = new Date();
        Date lastAccessed = new Date();
        Abbreviation abbr1 = new Abbreviation(1, "", "", "", false, "", addedAt, lastAccessed);
        Abbreviation abbr2 = new Abbreviation();

        mockedAbbreviations = Arrays.asList(abbr1, abbr2);
    }

    @Test
    void fetchAllAbbr() {
        //Mocking Page
        Page<Abbreviation> pageMock = new PageImpl<>(mockedAbbreviations);
        when(mockEventService.getAllAbbreviations(anyInt(), anyInt(), anyString(), anyBoolean())).thenReturn(pageMock);

        //Calling
        ResponseEntity<?> response = _controller.fetchAllAbbr("", true);
        List<?> actualListOfAbbr = (List<?>) response.getBody();

        //Testing
        assertEquals(response.getBody(), mockedAbbreviations);
        assert actualListOfAbbr != null;
        assertEquals(((Abbreviation)actualListOfAbbr.get(0)).getId(), 1);
    }

    @Test
    void fetchAbbr() {
        //Sample data
        Abbreviation abbr1 = new Abbreviation();
        Abbreviation abbr2 = new Abbreviation();
        List<Abbreviation> mockedAbbreviations = Arrays.asList(abbr1, abbr2);

        //Mocking Page
        Page<Abbreviation> pageMock = new PageImpl<>(mockedAbbreviations);
        when(mockEventService.getAbbreviationsFor(anyString(), anyInt(), anyInt())).thenReturn(pageMock);

        List<Abbreviation> actualResponse = _controller.fetchAbbr("TEST");
        assertEquals(actualResponse.size(), mockedAbbreviations.size());
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