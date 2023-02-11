package com.example.hw31.repository;

import com.example.hw31.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ludmila Litvinova on 09.02.23
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

}
