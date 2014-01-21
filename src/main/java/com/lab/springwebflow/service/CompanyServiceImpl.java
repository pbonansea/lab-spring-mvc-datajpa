/**
 * 
 */
package com.lab.springwebflow.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab.springwebflow.entity.Company;
import com.lab.springwebflow.repository.CompanyRepository;

/**
 * @author paolobonansea
 *
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    @Autowired
    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }
    
	/* (non-Javadoc)
	 * @see com.lab.springwebflow.service.CompanyService#findById(java.lang.Long)
	 */
	@Override
	public Company findById(Long id) {
		return repository.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.lab.springwebflow.service.CompanyService#find()
	 */
	@Override
	public List<Company> find() {
		return repository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.lab.springwebflow.service.CompanyService#save(com.lab.springwebflow.entity.Company)
	 */
	@Override
	public Company save(Company company) {
		return repository.saveAndFlush(company);
	}

	/* (non-Javadoc)
	 * @see com.lab.springwebflow.service.CompanyService#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		Company company = repository.findOne(id);
		if (company != null) {
			repository.delete(id);				
		}
	}

}