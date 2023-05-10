package org.dbaccess.service;

import org.dbaccess.model.entity.Vacancy;
import org.dbaccess.service.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacancyServiceImp implements VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    @Override
    public void create(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    @Override
    public Vacancy read(int id) {
        Optional<Vacancy> vacancy = vacancyRepository.findById(id);
        return vacancy.orElse(null);
    }

    @Override
    public List<Vacancy> readAll() {
        return vacancyRepository.findAll();
    }

    @Override
    public boolean update(Vacancy vacancy, int id) {
        return false;
    }

    @Override
    public void delete(int id) {
        vacancyRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        vacancyRepository.deleteAll();
    }
}
