package io.server.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "name must be entered")
    private String name;
    @NotNull(message = "email must be entered")
    @Email(message = "email must be valid ")
    @Column(unique = true)
    private String email;
    @NotNull(message = "password must be entered")
    private String password;
    @Enumerated(EnumType.STRING)
    @OneToOne(fetch = FetchType.EAGER)
    private Role roles;
}
