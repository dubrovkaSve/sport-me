package me.sport.controllers.user;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Value("classpath:static/users.json")
    private Resource users;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(
            value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public IdDto newUserDto(@RequestBody UserDto newUser) throws IOException {
        writeToDb(newUser);
        return new IdDto(newUser.getId());
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDto getUser(@PathVariable("id") UUID id) throws Exception {
        return readFromDb(id);
    }

    private Map<UUID, UserDto> readFromDb() throws IOException {
        return objectMapper.readValue(users.getFile(), new TypeReference<Map<UUID, UserDto>>(){});
    }

    private UserDto readFromDb(UUID id) throws IOException {
        return readFromDb().get(id);
    }

    private void writeToDb(UserDto userDto) throws IOException {
        var db = readFromDb();
        db.put(userDto.getId(), userDto);
        var temp = objectMapper.writeValueAsString(db);
        try(FileWriter writer = new FileWriter("C:/Java/springProjects/sport-me/src/main/resources/static/users.json")) {
            writer.flush();
            writer.write(temp);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}