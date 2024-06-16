package fr.epsi;


import jakarta.persistence.*;

@Entity
public class Fish extends Animal {
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FishLivEnv livingEnv;

    // Getters and Setters
    public FishLivEnv getLivingEnv() {
        return livingEnv;
    }

    public void setLivingEnv(FishLivEnv livingEnv) {
        this.livingEnv = livingEnv;
    }
}
