package com.andrewexe.userExam.models;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    private String country;

}
