package io.server;

import io.server.entity.Person;
import io.server.enums.Activity;
import io.server.enums.Gender;
import io.server.service.IPersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    CommandLineRunner run(IPersonService iPersonService){
        return args -> {
            Person reda = new Person(null,95,186, Activity.Very_Active, Gender.Male,23);
            iPersonService.addPerson(reda);
            Person imane = new Person(null,68,173, Activity.Very_Active, Gender.Female,20);
            iPersonService.addPerson(imane);
            Person tipo = new Person(null,74,175, Activity.Extra_Active, Gender.Male,22);
            iPersonService.addPerson(tipo);

        };
    }

}
