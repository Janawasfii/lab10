package com.example.lab9.Service;

import com.example.lab9.Model.JobPost;
import com.example.lab9.Repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JobPostService {
    private final JobPostRepository jobPostRepository;
    public List<JobPost> getJobPost() {
        return jobPostRepository.findAll();
    }
    public void addJobPost(JobPost jobPost) {
        jobPostRepository.save(jobPost);
    }
    public boolean updateJobPost(Integer id, JobPost jobPost) {
        JobPost jp = jobPostRepository.getById(id);
        if (jp == null) {
            return false;}
        jp.setTitle(jobPost.getTitle());
        jp.setDescription(jobPost.getDescription());
        jp.setLocation(jobPost.getLocation());
        jp.setSalary(jobPost.getSalary());
        jp.setPostingDate(jp.getPostingDate());
        jobPostRepository.save(jp);
        return true;
    }

    public boolean deleteJobPost(Integer id){
        JobPost jp = jobPostRepository.getById(id);
        if(jp == null){
            return false;
        }
        jobPostRepository.deleteById(id);
        return true;
    }
}
