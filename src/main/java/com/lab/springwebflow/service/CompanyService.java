/**
 * 
 */
package com.lab.springwebflow.service;

import java.util.List;

import com.lab.springwebflow.entity.Company;

/**
 * @author paolobonansea
 *
 */
public interface CompanyService {

	/**
	 * find company by id.
	 * @param id
	 * @return
	 */
	public Company findById(Long id);

    /**
     * find companies.
     * @return
     */
    public  List<Company> find();

    /**
     * Save company.
     * @param company
     * @return
     */
    public Company save(Company company);

    /**
     * Delete company.
     * @param id
     */
    public void delete(Long id);
	
}
