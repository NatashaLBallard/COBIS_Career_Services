package com.cobis_career_services.demo.repositories;

import com.cobis_career_services.demo.forms.Resume;
import org.springframework.data.repository.CrudRepository;

public interface ResumeRepository extends CrudRepository<Resume, Long> {
}