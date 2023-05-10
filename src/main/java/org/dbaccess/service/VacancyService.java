package org.dbaccess.service;

import org.dbaccess.model.entity.Vacancy;

import java.util.List;

public interface VacancyService {

    void create(Vacancy vacancy);

    Vacancy read(int id);

    List<Vacancy> readAll();

    boolean update(Vacancy vacancy, int id);

    void delete(int id);

    void deleteAll();
}
