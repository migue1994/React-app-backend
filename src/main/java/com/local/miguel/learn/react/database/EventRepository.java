package com.local.miguel.learn.react.database;

import com.local.miguel.learn.react.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {

}
