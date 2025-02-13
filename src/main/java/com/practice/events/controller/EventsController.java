package com.practice.events.controller;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.practice.events.model.Abbreviations;
import com.practice.events.model.Event;
import com.practice.events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EventsController {

    @Autowired
    private EventService eventService;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    public EventsController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String landing () {
        return "Connection Successful";
    }

    @GetMapping("/events")
    public Event fetchEvents(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Event(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/abbreviations")
    public List<Abbreviations> fetchAllAbbr() {
        return eventService.getAllAbbreviations();
    }
}
