package com.example.lab9.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name= "JobApplication")

public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message ="User ID must not be empty")
    @Column(columnDefinition = "int unique not null")
    private int userId;

    @NotNull(message ="Job Post ID must not be empty")
    @Column(columnDefinition = "int unique not null")
    private int jobPostId;
}
