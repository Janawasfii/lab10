package com.example.lab9.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "JobPost")
public class JobPost {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Title must not be empty")
    @Size(min=5)
    @Column(columnDefinition = "varchar(30) not null")
    private String title;

    @NotEmpty(message = "Description must not be null")
    @Column(columnDefinition = "varchar(150) not null")
    private String description;

    @NotEmpty(message = "Location must not be empty")
    @Column(columnDefinition = "varchar(50) not null")
    private String location;

    @NotNull(message = "Salary must not be null")
    @Positive(message = "Salary must be a positive number")
    @Column(columnDefinition = "int not null")
    private int salary;

    @NotNull(message = "Post Date should not be null")
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(columnDefinition = "DATE not null")
    private LocalDate postingDate;
}
