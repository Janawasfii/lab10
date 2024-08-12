package com.example.lab9.Controller;

import com.example.lab9.APIResponse.API;
import com.example.lab9.Model.JobPost;
import com.example.lab9.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/jobPost")
public class JobPostController {
    private final JobPostService jobPostService;
    @GetMapping("/get")
    public ResponseEntity getJobPost() {

        return ResponseEntity.status(200).body(jobPostService.getJobPost());
    }
    @PostMapping("/add")
    public ResponseEntity addJobPost(@Valid @RequestBody JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jobPostService.addJobPost(jobPost);
        return ResponseEntity.status(200).body(new API("Successfully added"));
    }

    @PutMapping("/update/{id}")
    public  ResponseEntity updateJobPost(@PathVariable Integer id,@Valid @RequestBody JobPost jobPost , Errors errors){
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = jobPostService.updateJobPost(id,jobPost);
        if(isUpdated){
            return ResponseEntity.status(200).body(new API("Successfully updated"));
        }
        return ResponseEntity.status(400).body(new API("Not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteJobPost(@PathVariable Integer id) {
        boolean isDeleted = jobPostService.deleteJobPost(id);
        if(isDeleted){
            return ResponseEntity.status(200).body("Successfully deleted");
        }
        return ResponseEntity.status(400).body("Not found");
    }
}
