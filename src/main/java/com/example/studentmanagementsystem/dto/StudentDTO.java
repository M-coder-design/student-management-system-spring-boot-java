package com.example.studentmanagementsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    @NotEmpty(message = "firstname should not be empty")
    private String firstName;
    @NotEmpty(message = "lastname should not be empty")
    private String lastName;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
}
