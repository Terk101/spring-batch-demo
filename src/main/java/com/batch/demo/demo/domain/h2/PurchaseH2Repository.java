package com.batch.demo.demo.domain.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseH2Repository extends JpaRepository<PurchaseH2, Long> {
}