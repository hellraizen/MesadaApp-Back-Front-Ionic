package com.dleite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dleite.domain.RequestPay;

@Repository
public interface RequestPayRepository extends JpaRepository<RequestPay, Integer> {

}
