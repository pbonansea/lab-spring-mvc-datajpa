package com.lab.springwebflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab.springwebflow.entity.Company;

/**
 * 
 * @author paolobonansea
 *
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
