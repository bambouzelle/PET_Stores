package fr.epsi;

import jakarta.persistence.*;

@Entity
public class Cat extends Animal {
    @Column(nullable = false)
    private String chipId;

    // Getters and Setters
    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }
}