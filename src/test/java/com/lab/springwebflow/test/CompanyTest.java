package com.lab.springwebflow.test;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.lab.springwebflow.entity.Company;
import com.lab.springwebflow.repository.CompanyRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-test.xml")
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class CompanyTest {

	static final Long ID_TO_FIND = 34L;
	
    @Autowired
    private CompanyRepository companyRepository;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception { }

	@AfterClass
	public static void tearDownAfterClass() throws Exception { }

	@Before
	public void setUp() throws Exception { }

	@After
	public void tearDown() throws Exception { }

	@Test
	public void testFindById() {

		Company company = companyRepository.findOne(ID_TO_FIND);
		
		assert(company != null);
		
	}

	@Test
	public void testSave() {
		
		Company company = new Company();
		company.setName("test spring data jpa");
		
		companyRepository.save(company);
		
		assert(company.getId() != null);
		
	}

	@Test
	public void testDelete() {

		List<Company> listCompanies = companyRepository.findAll();
		
		if (!listCompanies.isEmpty()) {

			Company companyDeleted = listCompanies.get(0);

			companyRepository.delete(companyDeleted);;
						
			assert(companyDeleted != null);
			
		} else {
			assert(true);
		}
		
	}
	
}
