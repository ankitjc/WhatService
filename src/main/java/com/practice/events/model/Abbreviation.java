package com.practice.events.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "abbreviation")
public class Abbreviation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "shortForm")
    private String shortForm;

    @Column(name = "longForm")
    private String longForm;

    @Column(name = "description")
    private String description;

    @Column(name = "isDeleted")
    private boolean isDeleted;

    @Column(name = "addedBy")
    private String addedBy;

    @Column(name = "addedAt")
    private Date addedAt;

    @Column(name = "lastAccessed")
    private Date lastAccessed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShortForm() {
        return shortForm;
    }

    public void setShortForm(String shortForm) {
        this.shortForm = shortForm;
    }

    public String getLongForm() {
        return longForm;
    }

    public void setLongForm(String longForm) {
        this.longForm = longForm;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }

    public Date getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(Date lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    @Override
    public String toString() {
        return "Abbreviations{" +
                "id=" + id +
                ", shortForm='" + shortForm + '\'' +
                ", longForm='" + longForm + '\'' +
                ", description='" + description + '\'' +
                ", isDeleted=" + isDeleted +
                ", addedBy='" + addedBy + '\'' +
                ", addedAt=" + addedAt +
                ", lastAccessed=" + lastAccessed +
                '}';
    }

    // other fields, getters, setters
}