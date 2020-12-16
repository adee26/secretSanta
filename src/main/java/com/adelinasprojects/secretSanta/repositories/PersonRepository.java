package com.adelinasprojects.secretSanta.repositories;

import com.adelinasprojects.secretSanta.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
