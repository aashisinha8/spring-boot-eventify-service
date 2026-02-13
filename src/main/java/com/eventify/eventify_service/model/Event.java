package com.eventify.eventify_service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events")
public class Event {

    @Id
    private String id;

    private String title;
    private String description;
    private String location;
    private String organizerId;

    // ✅ Default Constructor (Required by Spring/Mongo)
    public Event() {
    }

    // ✅ Parameterized Constructor (Without id)
    public Event(String title, String description, String location, String organizerId) {
        this.title = title;
        this.description = description;
        this.location = location;
        this.organizerId = organizerId;
    }

    // ✅ Full Constructor
    public Event(String id, String title, String description, String location, String organizerId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.organizerId = organizerId;
    }

    // ---------------- GETTERS ----------------

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getOrganizerId() {
        return organizerId;
    }

    // ---------------- SETTERS ----------------

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOrganizerId(String organizerId) {
        this.organizerId = organizerId;
    }
}
