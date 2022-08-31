package me.sport.controllers.program;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/programs") //every query to path /programs* will be passed here
public class ProgramController {

    @Value("classpath:static/db.json")
    private Resource db;

    @GetMapping(
            path = "",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProgramListViewDto> getPrograms() throws Exception {
        return readFromDb();
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ProgramDto retrieveProgram(@PathVariable("id") UUID id) throws Exception {
        return readFromDb(id);
    }

    private List<ProgramListViewDto> readFromDb() throws Exception {
        var objectMapper = new ObjectMapper();
        return objectMapper.readValue(db.getFile(), new TypeReference<List<ProgramListViewDto>>(){});
    }

    private ProgramDto readFromDb(UUID id) throws Exception {
        var objectMapper = new ObjectMapper();
        var programs = objectMapper.readValue(db.getFile(), new TypeReference<List<ProgramDto>>(){});
        return programs.stream()
                .filter(program -> program.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("The program hasn't been found by id"));
    }
}
