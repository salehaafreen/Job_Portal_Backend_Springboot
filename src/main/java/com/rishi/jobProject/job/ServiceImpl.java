package com.rishi.jobProject.job;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements service{
    JobRepository jobRepository;

    public ServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    //private List<Job> jobs = new ArrayList<>();
    private long NextId = 1L;
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createjob(Job job) {
        job.setJObID(NextId++);
        jobRepository.save(job);


    }

    @Override
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteJobById(Long id) {
        try {
            jobRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean UpdateJobByID(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);

            if(jobOptional.isPresent()){
                Job job = jobOptional.get();
                job.setDesc(updatedJob.getDesc());
                job.setLocation(updatedJob.getLocation());
                job.setMaxSalary(updatedJob.getMaxSalary());
                job.setMinSalary(updatedJob.getMinSalary());
                job.setTitle(updatedJob.getTitle());
                jobRepository.save(job);
                return true;


            }


        return false;
    }
}
