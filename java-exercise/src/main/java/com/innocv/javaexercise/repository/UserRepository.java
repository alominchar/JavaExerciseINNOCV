package com.innocv.javaexercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.innocv.javaexercise.entity.User;

/**
 * Repository for the user entity
 * @author Abraham Lominchar
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
