package org.dbaccess.service;

import org.dbaccess.model.entity.Vacancy;

import java.util.List;

public interface VacancyService {

    void create(Vacancy vacancy);

    Vacancy read(int id);

    List<Vacancy> readALl();

    boolean update(Vacancy vacancy, int id);

    boolean delete(int id);
}
