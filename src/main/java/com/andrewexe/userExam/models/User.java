package com.andrewexe.userExam.models;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "users") // так как user зарезервировано системой, указываем другое имя.
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String firstName;

    @Getter
    private int age;

    @Getter
    @Enumerated(EnumType.STRING)
    private Country country;
}
