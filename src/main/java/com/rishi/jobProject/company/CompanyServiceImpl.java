package com.rishi.jobProject.company;

import com.rishi.jobProject.job.Job;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanySerivce {
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public boolean updateCompany(Company company, Long id) {
        Optional<Company> companyOptional = companyRepository.findById(id);

        if (companyOptional.isPresent()) {
            Company comp = companyOptional.get();
            comp.setDesc(company.getDesc());
            comp.setName(company.getName());
            comp.setJobs(company.getJobs());
            companyRepository.save(comp);
            return true;
        }
        return false;
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);

    }

    @Override
    public boolean deleteCompnyById(Long id) {
        if(companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }
        else return false;
    }

    @Override
    public Company findComapnybyID(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}
