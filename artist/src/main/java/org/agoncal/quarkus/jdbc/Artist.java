package org.agoncal.quarkus.jdbc;

import java.time.Instant;

public class Artist {

    private Long id;
    private String name;
    private String bio;
    private Instant createdDate = Instant.now();


    public Artist(String name, String bio) {
        this.name = name;
        this.bio = bio;
    }

    public Long getId() {
        return id;
    }

    public Artist setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Artist setName(String name) {
        this.name = name;
        return this;
    }

    public String getBio() {
        return bio;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public Artist setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Artist() {
    }

    public Artist(Long id, String name, String bio, Instant createdDate) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.createdDate = createdDate;
    }

    public Artist setBio(String bio) {
        this.bio = bio;
        return this;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
