package com.fviel.jsonmngr.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fviel.jsonmngr.model.Person;
import com.fviel.jsonmngr.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {
    
    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping
    public List<Person> list(){
        return personService.list();
    }

    @PostMapping
    public Person create(@RequestBody Person person){
        return personService.save(person);
    }

}
