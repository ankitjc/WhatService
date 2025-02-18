package com.practice.events.controller;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.practice.events.model.Abbreviations;
import com.practice.events.model.Event;
import com.practice.events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping("/events")
//    public Event fetchEvents(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return new Event(counter.incrementAndGet(), String.format(template, name));
//    }

    //Added comment
    @GetMapping("/abbreviations")
    public List<Abbreviations> fetchAllAbbr() {
        return eventService.getAllAbbreviations();
    }

    @GetMapping("/abbreviation")
    public List<Abbreviations> fetchAbbr(@RequestParam(value = "value", defaultValue = "AAC") String abbr) {
        return eventService.getAbbreviationsFor(abbr);
    }

    @PostMapping("/abbreviation")
    public boolean addAbbr(
            @RequestParam(value = "value", defaultValue = "") String abbr,
            @RequestParam(value = "description", defaultValue = "") String description,
            @RequestParam(value = "addedBy", defaultValue = "") String addedBy) {
        System.out.println("Entry added start...");
        Abbreviations newAbbreviation = new Abbreviations();
        newAbbreviation.setAbbreviation(abbr);
        newAbbreviation.setLongform(description);
        newAbbreviation.setAddedby(addedBy);
        newAbbreviation.setAddedat(new Date());
        newAbbreviation.setLastaccessed(new Date());
        eventService.updateOrInsertUsingRepository(newAbbreviation);

        return true;
    }

}
