package com.example.lab9.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name= "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name must not be empty")
    @Size(min = 5)
    @Pattern(regexp="^[a-zA-Z]*$",message ="Only characters")
  //  @Column(columnDefinition = "varchar(20) unique not null check(name regexp=\"^[a-zA-Z]*$")
    private String name;

    @NotEmpty(message = "Email should not be empty")
    @Email
    @Column(columnDefinition = "varchar(50) unique not null")
    private String email;

    @NotEmpty(message = "Password must not be empty")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{7,}$")
    @Column(columnDefinition = "varchar(50) not null ")
    private String password;

    @NotNull(message = "Age must not be null")
    @Positive(message = "Age must be a positive number")
    @Min(22)
    @Column(columnDefinition = "int not null")
    private int age;

    @NotEmpty(message = "Role must not be empty")
    @Pattern(regexp="^(JOB_SEEKER|EMPLOYER)$",message =" You have only 2 options (JOB_SEEKER or EMPLOYER) only")
    //@Column(columnDefinition = "varchar(15) check (role= 'JOB_SEEKER' or role= 'EMPLOYER') ")
    private String role;




}
