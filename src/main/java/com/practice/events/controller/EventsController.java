package com.practice.events.controller;
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
    public List<Abbreviation> fetchAllAbbr(@RequestParam(value = "sortBy", defaultValue = "lastAccessed") String sortBy,
            @RequestParam(value = "isDescending", defaultValue = "true") boolean isDescending) {
        return eventService.getAllAbbreviations(0, 10, sortBy, isDescending).getContent();
    }

    @GetMapping("/abbreviation")
    public List<Abbreviation> fetchAbbr(@RequestParam(value = "shortForm", defaultValue = "") String abbr) {
        return eventService.getAbbreviationsFor(abbr, 0, 10).getContent();
    }

    @PostMapping("/abbreviation")
    public boolean addOrUpdateAbbreviation(@RequestBody Abbreviation abbreviation) {
        eventService.updateOrInsertUsingRepository(abbreviation);
        return true;
    }

    @DeleteMapping("/abbreviation")
    public boolean deleteAbbreviation(@RequestParam(value = "id") int id) {
        eventService.deleteAbbreviation(id);
        return true;
    }

    @GetMapping("/leaderboard")
    public List<Leader> getLeaderboard() {
        return eventService.getLeaderboard();
    }

}
