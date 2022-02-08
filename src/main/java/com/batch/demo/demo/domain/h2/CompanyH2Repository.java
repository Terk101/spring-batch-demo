package com.batch.demo.demo.domain.h2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyH2Repository extends CrudRepository<CompanyH2, String> {
}
