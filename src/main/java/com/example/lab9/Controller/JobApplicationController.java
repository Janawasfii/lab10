package com.example.lab9.Controller;

import com.example.lab9.Model.JobApplication;
import com.example.lab9.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/jobApp")
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;
    @GetMapping("/get")
    public ResponseEntity getJobApplication() {

        return ResponseEntity.status(200).body(jobApplicationService.getJobApplication());
    }
    @PostMapping("/add")
    public ResponseEntity addJobPost(@Valid @RequestBody JobApplication jobApplication, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jobApplicationService.addJobApplication(jobApplication);
        return ResponseEntity.status(200).body(" Successfully added");
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity updateJobPost(@PathVariable Integer id,@Valid @RequestBody JobApplication jobApplication , Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = jobApplicationService.updateJobApplication(id,jobApplication);
        if(isUpdated){
            return ResponseEntity.status(200).body("Successfully updated");
        }
        return ResponseEntity.status(400).body("Not found");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobApplication(@PathVariable Integer id) {

        boolean isDeleted = jobApplicationService.deleteJobApplication(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("Successfully deleted");
        }
        return ResponseEntity.status(400).body("Not found");
    }
}
