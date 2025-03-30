package com.practice.events.service;

import com.practice.events.model.Abbreviation;
import com.practice.events.model.Leader;
import com.practice.events.model.WhatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private WhatRepository whatRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(EventService.class);

    public EventService(WhatRepository whatRepo) {
        this.whatRepo = whatRepo;
    }

    public Page<Abbreviation> getAllAbbreviations(int pageNumber, int pageSize, String sortBy, boolean isDesc) {
        Sort sort = isDesc ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        LOGGER.info("Fetched all abbreviations.");
        return whatRepo.findAll(pageable);
    }


    public Page<Abbreviation> getAbbreviationsFor(String abbr, int pageNumber, int pageSize) {
        if(abbr.isBlank()) return Page.empty();
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Abbreviation> result = whatRepo.findByShortForm(abbr, pageable);
        LOGGER.info("Fetched specific abbreviation for {}. Abbreviations fetched :: {} ", abbr, result.getTotalElements());
        return result;
    }

    public List<Leader> getLeaderboard() {
        List<Object[]> result = whatRepo.getLeaderboard();

        List<Leader> leaderboard = new ArrayList<>();

        for(Object[] o: result) {
            leaderboard.add(new Leader((String) o[0], (Long) o[1]));
        }
        LOGGER.info("Leaderboard received. Size :: {}", leaderboard.size());
        return leaderboard;
    }

    public void updateOrInsertUsingRepository(Abbreviation abbreviation) {
        abbreviation.setLastAccessed(new Date());

        if(abbreviation.getId() == null) {
            abbreviation.setAddedAt(new Date());
        }

        LOGGER.info("Saving:: {} ", abbreviation);
        whatRepo.updateOrInsert(abbreviation);
    }

    public void deleteAbbreviation(int id) {
        LOGGER.info("Deleting :: {} ", id);
        whatRepo.deleteById(id);
    }
}
