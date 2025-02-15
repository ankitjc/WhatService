package com.practice.events.model;

public class Leader {
    String name;
    Long abbrAdded;

    public Leader(String name, Long abbrAdded) {
        this.name = name;
        this.abbrAdded = abbrAdded;
    }

    public Long getAbbrAdded() {
        return abbrAdded;
    }

    public void setAbbrAdded(Long abbrAdded) {
        this.abbrAdded = abbrAdded;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
