package com.practice.events.controller;
import java.util.Date;
import java.util.List;

import com.practice.events.model.Abbreviations;
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
    public String landing () {
        return "Connection Successful";
    }

    @GetMapping("/abbreviations")
    public List<Abbreviations> fetchAllAbbr() {
        return eventService.getAllAbbreviations();
    }

    @GetMapping("/abbreviation")
    public List<Abbreviations> fetchAbbr(@RequestParam(value = "shortform", defaultValue = "") String abbr) {
        return eventService.getAbbreviationsFor(abbr);
    }

    @GetMapping("/leaderboard")
    public List<Leader> getLeaderboard() {
        return eventService.getLeaderboard();
    }

    @PostMapping("/abbreviation")
    public boolean addAbbr(
            @RequestParam(value = "shortform", defaultValue = "") String abbr,
            @RequestParam(value = "longform", defaultValue = "") String longform,
            @RequestParam(value = "description", defaultValue = "") String description,
            @RequestParam(value = "addedBy", defaultValue = "") String addedBy) {
        Abbreviations newAbbreviation = new Abbreviations();
        newAbbreviation.setAbbreviation(abbr);
        newAbbreviation.setLongform(longform);
        newAbbreviation.setDescription(description);
        newAbbreviation.setAddedby(addedBy);
        newAbbreviation.setAddedat(new Date());
        newAbbreviation.setLastaccessed(new Date());
        eventService.updateOrInsertUsingRepository(newAbbreviation);

        return true;
    }

}
