package com.rishi.jobProject.company;



import java.util.List;

public interface CompanySerivce {

    public List<Company> getAllCompanies();

    boolean updateCompany(Company company,Long id);

    public void createCompany(Company company);

    boolean deleteCompnyById(Long id);
    public Company findComapnybyID(Long id);

}
