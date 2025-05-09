package com.rishi.jobProject.job;

import com.rishi.jobProject.company.Company;
import jakarta.persistence.*;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long JObID;
    private String title;
    private String Desc;
    private String minSalary;
    private String maxSalary;
    private String location;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
        
    }

    @ManyToOne
    private Company company;



    public Long getJObID() {
        return JObID;
    }

    public void setJObID(Long JObID) {
        this.JObID = JObID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Job(Long JObID, String title, String desc, String minSalary, String maxSalary, String location) {
        this.JObID = JObID;
        this.title = title;
        Desc = desc;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    public Job() {
    }
}
