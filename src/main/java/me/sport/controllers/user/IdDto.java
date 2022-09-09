package me.sport.controllers.user;

import java.io.Serializable;
import java.util.UUID;

public class IdDto implements Serializable {

    private UUID id;

    public IdDto(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
