package com.local.miguel.learn.react.database;

import com.local.miguel.learn.react.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, String> {
}
