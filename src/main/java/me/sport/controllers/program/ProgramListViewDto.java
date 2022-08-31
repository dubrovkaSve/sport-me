package me.sport.controllers.program;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProgramListViewDto implements Serializable {

    private UUID id;
    private String title;
    private Date created;
    private Date updated;

    public ProgramListViewDto(UUID id, String title, Date created, Date updated) {
        this.id = id;
        this.title = title;
        this.created = created;
        this.updated = updated;
    }

    public ProgramListViewDto() {
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

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

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

}
