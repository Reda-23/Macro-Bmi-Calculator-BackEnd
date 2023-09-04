package io.server.service;

import io.server.entity.Person;


import java.util.List;

public interface IPersonService {


    Person addPerson(Person person);
    double calculateMacro(Person person);

    double calculateBMI(Person person);

    List<Person> findAll();


    void deletePerson(Long id) ;
}
