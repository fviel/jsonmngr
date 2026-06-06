package com.fviel.jsonmngr.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fviel.jsonmngr.model.Person;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

@Service
public class PersonService {

    private static final String FILE = "persons.json";
    private final ObjectMapper mapper = new ObjectMapper();


    public List<Person> list() {
        try {
            File file = new File(FILE);
            if (!file.exists()) {
                return new ArrayList<>();
            }
            return mapper.readValue(file, new TypeReference<List<Person>>() {
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Person save(Person person){
        List<Person> persons = list();
        long newId = persons.stream()
        .mapToLong(p -> p.getId())
        .max()
        .orElse(0L) + 1;

        Person newPerson = new Person(newId, person.getName(), person.getAge());

        persons.add(newPerson);

        persistFile(persons);

        return newPerson;
    }

    public void persistFile(List<Person> persons){
        try{
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE), persons);
        }catch(Exception e){
            throw new RuntimeException(e);
        }        
    }
}
