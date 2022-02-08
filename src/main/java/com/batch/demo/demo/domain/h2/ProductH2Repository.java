package com.batch.demo.demo.domain.h2;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;

@Repository
public interface ProductH2Repository extends CrudRepository<ProductH2, String> {
}
