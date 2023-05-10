package org.dbaccess.controller;

import lombok.extern.slf4j.Slf4j;
import org.dbaccess.model.entity.Vacancy;
import org.dbaccess.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;
@RestController
public class VacancyController {

    private static final Logger LOGGER = Logger.getLogger(VacancyController.class.getName());

    @Autowired
    VacancyService vacancyService;

    @GetMapping(value = "/")
    private ResponseEntity<List<Vacancy>> getAllVacancies() {
        LOGGER.info("GET / request received");
        List<Vacancy> vacancyList = vacancyService.readALl();
        vacancyList.forEach(System.out::println);
        return new ResponseEntity<>(vacancyList, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    private ResponseEntity<Vacancy> createVacancy(@RequestBody Vacancy vacancy) {
        LOGGER.info("POST / request received");
        LOGGER.info(vacancy.toString());

        vacancyService.create(vacancy);
        return new ResponseEntity<>(vacancy, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<Vacancy> getVacancyById(@PathVariable int id) {
        LOGGER.info("GET /%d request received".formatted(id));
        Vacancy vacancy = vacancyService.read(id);
        if (vacancy == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(vacancy, HttpStatus.OK);
    }
}
