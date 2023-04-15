package org.dbaccess.controller;

import org.dbaccess.model.entity.Vacancy;
import org.dbaccess.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VacancyController {

    @Autowired
    VacancyService vacancyService;

    @GetMapping(value = "/")
    private ResponseEntity<List<Vacancy>> getAllVacancies() {
        List<Vacancy> vacancyList = vacancyService.readALl();
        vacancyList.forEach(System.out::println);
        return new ResponseEntity<>(vacancyList, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<Vacancy> createVacancy(@RequestBody Vacancy vacancy) {
        vacancyService.create(vacancy);
        return new ResponseEntity<>(vacancy, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<Vacancy> getVacancy(@PathVariable int id) {
        Vacancy vacancy = vacancyService.read(id);
        if (vacancy == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(vacancy, HttpStatus.OK);
    }
}
