package com.practice.events.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "abbreviations")
public class Abbreviations {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "abbreviation")
    private String abbreviation;

    @Column(name = "longform")
    private String longForm;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getLongForm() {
        return longForm;
    }

    public void setLongForm(String longForm) {
        this.longForm = longForm;
    }

//    @Column(name = "addedBy")
//    private String addedBy;

    // other fields, getters, setters
}