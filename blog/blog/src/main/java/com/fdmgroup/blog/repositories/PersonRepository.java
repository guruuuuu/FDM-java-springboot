package com.fdmgroup.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.blog.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
