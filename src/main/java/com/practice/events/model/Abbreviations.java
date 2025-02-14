package com.practice.events.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.util.Date;

@Entity
@Table(name = "abbreviations")
public class Abbreviations {
    @Id
//    @Generated(GenerationTime.INSERT)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "abbreviation")
    private String abbreviation;

    @Column(name = "longform")
    private String longform;

    @Column(name = "addedby")
    private String addedby;

    @Column(name = "addedat")
    private Date addedat;

    @Column(name = "lastaccessed")
    private Date lastaccessed;

    public Date getAddedat() {
        return addedat;
    }

    public void setAddedat(Date addedat) {
        this.addedat = addedat;
    }

    public Date getLastaccessed() {
        return lastaccessed;
    }

    public void setLastaccessed(Date lastaccessed) {
        this.lastaccessed = lastaccessed;
    }

    public String getAddedby() {
        return addedby;
    }

    public void setAddedby(String addedby) {
        this.addedby = addedby;
    }

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

    public String getLongform() {
        return longform;
    }

    public void setLongform(String longForm) {
        this.longform = longForm;
    }


    // other fields, getters, setters
}