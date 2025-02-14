package com.practice.events.service;

import com.practice.events.model.Abbreviations;
import com.practice.events.model.WhatRepository;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private WhatRepository whatRepo;

    public Abbreviations getAbbreviationById(int id) {
        return whatRepo.findById(id).orElse(null);
    }

    public List<Abbreviations> getAllAbbreviations() {
        List<Abbreviations> allAbbr = whatRepo.findAll();
        System.out.println("List of All abbreviations fetched:: " +  allAbbr.size());
        return allAbbr;
    }

    public List<Abbreviations> getAbbreviationsFor(String abbr) {
        List<Abbreviations> allAbbr = whatRepo.findByAbbreviation(abbr);
        System.out.println("List of abbreviations fetched when searching for '" + abbr + "' ::"+  allAbbr.size());
        return allAbbr;
    }

    public void updateOrInsertUsingRepository(Abbreviations abbreviation) {
        System.out.println("Saving: " + abbreviation);
        whatRepo.updateOrInsert(abbreviation);
    }


}
