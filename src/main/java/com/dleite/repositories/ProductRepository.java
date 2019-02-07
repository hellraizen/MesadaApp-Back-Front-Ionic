package com.dleite.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dleite.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
