package com.cobis_career_services.demo.repositories;


import com.cobis_career_services.demo.model.AppRole;
import org.springframework.data.repository.CrudRepository;

public interface AppRoleRepository extends CrudRepository<AppRole, Long> {
    AppRole findByRole(String role);
}