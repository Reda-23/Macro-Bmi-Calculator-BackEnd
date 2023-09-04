package io.server.service;

import io.server.entity.Person;
import io.server.enums.Gender;
import io.server.exception.PersonNotFoundException;
import io.server.repo.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class IPersonServiceImpl implements IPersonService {

    private final PersonRepository personRepository;


    @Override
    public Person addPerson(Person person) {
        Person addedPerson = personRepository.save(person);
        if (addedPerson.getGender() == null){
            log.warn("the person data is null ");
        }
        log.info("adding a new person ");
        return personRepository.save(person);
    }

    @Override
    public double calculateMacro(Person person) {
        log.info("inside the calculate macro function");
        double macro = 0;
        if (person.getGender().equals(Gender.Male)){
            macro =  (10 * person.getWeight()) + (6.25 * person.getHeight())  -  (5*person.getAge()) + 5;
        } else if (person.getGender().equals(Gender.Female)) {
            macro =  (10 * person.getWeight()) + (6.25 * person.getHeight())  -  (5*person.getAge()) - 161;
        }
        switch (person.getActivity()){
            case Sedentary -> {macro = macro * 1.2;}
            case Lightly_Active -> {macro = macro * 1.375;}
            case Moderately_Active -> {macro = macro * 1.55;}
            case Very_Active -> {macro = macro * 1.725;}
            case Extra_Active -> {macro = macro * 1.9;}
        }
        return macro;
    }

    @Override
    public double calculateBMI(Person person) {
        double bmi;
        bmi = person.getWeight()/ Math.pow(person.getHeight() / 100,2);
        return bmi;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public void deletePerson(Long id) {
        Person person= personRepository.getReferenceById(id);
        personRepository.delete(person);
    }

}
