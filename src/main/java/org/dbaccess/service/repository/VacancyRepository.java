package org.dbaccess.service.repository;

import org.dbaccess.model.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Integer> {
}
