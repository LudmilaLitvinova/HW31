package com.example.hw31.repository;

import com.example.hw31.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Ludmila Litvinova on 09.02.23
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findFirstByName(String name);

    boolean existsUserByName(String name);


}
