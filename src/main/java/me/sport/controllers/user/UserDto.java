package me.sport.controllers.user;

import java.io.Serializable;
import java.util.UUID;

public class UserDto implements Serializable {

    private String login;
    private String firstName;
    private String lastName;
    private UUID id;

    public UserDto(String login, String firstName, String lastName) {
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = UUID.randomUUID();
    }

    public UserDto() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

