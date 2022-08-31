package me.sport.controllers.program;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ProgramDto implements Serializable {

    private UUID id;
    private String title;
    private String description;
    private Date created;
    private Date updated;

    public ProgramDto() {

    }

    public ProgramDto(UUID id, String title, String description, Date created, Date updated) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.created = created;
        this.updated = updated;
    }


    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() { return description; }

    public String getCreated() {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        return formatter.format(created);
    }

    public String getUpdated() {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        return formatter.format(updated);
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

}

