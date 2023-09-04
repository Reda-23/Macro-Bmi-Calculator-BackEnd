package io.server.entity;

import io.server.enums.Activity;
import io.server.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "weight must be entered")
    private double weight;
    @NotNull(message = "height must be entered")
    private double height;
    @Enumerated(EnumType.STRING)

    private Activity activity;
    @Enumerated(EnumType.STRING)

    private Gender gender;

    private int age;

}
