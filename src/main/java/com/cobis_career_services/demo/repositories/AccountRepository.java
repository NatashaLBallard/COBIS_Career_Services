package com.cobis_career_services.demo.repositories;


import com.cobis_career_services.demo.forms.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long>{
}