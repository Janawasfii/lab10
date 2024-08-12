package com.example.lab9.Repository;

import com.example.lab9.Model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer> {

}
