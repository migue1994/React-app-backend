package com.local.miguel.learn.react.controller;

import com.local.miguel.learn.react.database.EventRepository;
import com.local.miguel.learn.react.database.GroupRepository;
import com.local.miguel.learn.react.database.PersonRepository;
import com.local.miguel.learn.react.model.Event;
import com.local.miguel.learn.react.model.Grupo;
import com.local.miguel.learn.react.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/")
public class ApiController {

    private final PersonRepository personRepository;
    private final GroupRepository groupRepository;
    private final EventRepository eventRepository;

    public ApiController(PersonRepository personRepository, GroupRepository groupRepository, EventRepository eventRepository) {
        this.personRepository = personRepository;
        this.groupRepository = groupRepository;
        this.eventRepository = eventRepository;
    }

    @GetMapping("persons")
    public ResponseEntity<?> getPersons(){
        try {
            return new ResponseEntity<>(personRepository.findAll(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Doesn't exist any person", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("events")
    public ResponseEntity<?> getEvents(){
        try {
            return new ResponseEntity<>(eventRepository.findAll(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Doesn't exist any event", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("groups")
    public ResponseEntity<?> getGroups(){
        try {
            return new ResponseEntity<>(groupRepository.findAll(), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Doesn't exist any group", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("persons")
    public ResponseEntity<?> putPerson(@RequestBody @Valid Person person){
        try {
            personRepository.save(person);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Don't was able to update the person", HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("events")
    public ResponseEntity<?> putEvent(@RequestBody @Valid Event event){
        try {
            eventRepository.save(event);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Don't was able to update the event", HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("groups")
    public ResponseEntity<?> putGroup(@RequestBody @Valid Grupo grupo){
        try {
            groupRepository.save(grupo);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Don't was able to update the group", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("persons/{person}")
    public ResponseEntity<?> getPerson(@PathVariable String person){
        try {
            return new ResponseEntity<>(personRepository.findById(person), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Don't as able to found the person", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("events/{event}")
    public ResponseEntity<?> getEvent(@PathVariable long event){
        try {
            return new ResponseEntity<>(eventRepository.findById(event), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Don't as able to found the event", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("groups/{group}")
    public ResponseEntity<?> getGroup(@PathVariable long group){
        try {
            return new ResponseEntity<>(groupRepository.findById(group), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Don't as able to found the group", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("groups")
    public ResponseEntity<?> postGroup(@RequestBody @Valid Grupo grupo){
        try {
            groupRepository.save(grupo);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Don't was able to post the group", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("events")
    public ResponseEntity<?> postEvent(@RequestBody @Valid Event event){
        try {
            eventRepository.save(event);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Don't was able to post the event", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("persons")
    public ResponseEntity<?> postPerson(@RequestBody @Valid Person person){
        try {
            personRepository.save(person);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Don't was able to post the person", HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("groups/{group}")
    public ResponseEntity<?> deleteGroup(@PathVariable long group){
        try {
            groupRepository.deleteById(group);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Don't was able to delete the group", HttpStatus.FORBIDDEN);
        }
    }
}
