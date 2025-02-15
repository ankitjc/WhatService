package com.practice.events.service;

import com.practice.events.model.Abbreviations;
import com.practice.events.model.WhatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private WhatRepository whatRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(EventService.class);;

    public List<Abbreviations> getAllAbbreviations() {
        List<Abbreviations> allAbbr = whatRepo.findAll();
        LOGGER.info("List of All abbreviations fetched :: {}", allAbbr.size());
        return allAbbr;
    }

    public List<Abbreviations> getAbbreviationsFor(String abbr) {
        List<Abbreviations> allAbbr = whatRepo.findByAbbreviation(abbr);
        LOGGER.info("List of abbreviations fetched when searching for {} :: {} ", abbr, allAbbr.size());
        return allAbbr;
    }

    public void updateOrInsertUsingRepository(Abbreviations abbreviation) {
        LOGGER.info("Saving:: {} ", abbreviation);
        whatRepo.updateOrInsert(abbreviation);
    }


}
