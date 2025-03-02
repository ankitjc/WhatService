package com.practice.events.controller;
import java.util.Date;
import java.util.List;

import com.practice.events.model.Abbreviation;
import com.practice.events.model.Leader;
import com.practice.events.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class EventsController {

    @Autowired
    private final EventService eventService;

    public EventsController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String check() {
        return "Connection Successful";
    }
    
    @GetMapping("/abbreviations")
    public List<Abbreviation> fetchAllAbbr() {
        return eventService.getAllAbbreviations();
    }

    @GetMapping("/abbreviation")
    public List<Abbreviation> fetchAbbr(@RequestParam(value = "shortForm", defaultValue = "") String abbr) {
        return eventService.getAbbreviationsFor(abbr);
    }

    @GetMapping("/leaderboard")
    public List<Leader> getLeaderboard() {
        return eventService.getLeaderboard();
    }

    @PostMapping("/abbreviation")
    public boolean addOrUpdateAbbreviation(@RequestBody Abbreviation abbreviation) {
        abbreviation.setAddedAt(new Date());
        abbreviation.setLastAccessed(new Date());
        eventService.updateOrInsertUsingRepository(abbreviation);
        return true;
    }

}
