package com.local.miguel.learn.react.database;

import com.local.miguel.learn.react.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Grupo, Long> {
}
