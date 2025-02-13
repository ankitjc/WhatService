package com.practice.events.controller;
import java.util.concurrent.atomic.AtomicLong;

import com.practice.events.model.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public String landing () {
        return "Connection Successful";
    }

    @GetMapping("/events")
    public Event fetchEvents(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Event(counter.incrementAndGet(), String.format(template, name));
    }
}
