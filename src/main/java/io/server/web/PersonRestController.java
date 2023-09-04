package io.server.web;


import io.server.entity.Person;
import io.server.service.IPersonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
@CrossOrigin("*")
public class PersonRestController {

    private final IPersonService personService;

    @PostMapping("/")
    public Person addPerson(@RequestBody Person person){
        log.info("added the person and returning the macro");
        return personService.addPerson(person);
    }

    @PostMapping("/bmi")
    public double calcBMI(@RequestBody Person person){
       // personService.addPerson(person);
        log.info("added the person and returning the bmi");
        return personService.calculateBMI(person);
    }

    @PostMapping("/macro")
    public double calcMacro(@RequestBody Person person){
        personService.addPerson(person);
        log.info("added the person and returning the macro");
        return personService.calculateMacro(person);
    }

    @GetMapping("/persons")
    public List<Person> personList(){
            return personService.findAll();
    }


    @DeleteMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return "Person deleted";
    }


}
