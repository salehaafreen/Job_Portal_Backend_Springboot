package com.rishi.jobProject.job;

import java.util.List;

public interface service {
    public List<Job> findAll();

    public void createjob(Job job);

    Job getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean UpdateJobByID(Long id, Job updatedJob);
}
