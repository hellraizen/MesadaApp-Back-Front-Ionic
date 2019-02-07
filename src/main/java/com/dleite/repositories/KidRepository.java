package com.dleite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dleite.domain.Kid;

@Repository
public interface KidRepository extends JpaRepository<Kid, Integer> {

}
