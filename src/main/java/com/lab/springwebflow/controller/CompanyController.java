/**
 * 
 */
package com.lab.springwebflow.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lab.springwebflow.entity.Company;
import com.lab.springwebflow.service.CompanyService;

/**
 * @author paolobonansea
 *
 */
@Controller
public class CompanyController {

    final Logger logger = LoggerFactory.getLogger(getClass());
    
    private final CompanyService service;

    @ModelAttribute("company")
    public Company getCompany() {
    	return new Company();
    }
    
    @Autowired
    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @RequestMapping(value="/company",method=RequestMethod.GET)    
    public ModelAndView init(Model model){
    
    	ModelAndView mv = new ModelAndView();
    
    	List<Company> listCompany = service.find();
    	
        mv.setViewName("company");
        
        model.addAttribute("listCompany", listCompany);
        Company company = new Company();
        model.addAttribute("company", company);
        
        return mv;
        
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    public ModelAndView create(@ModelAttribute(value="company") Company company, BindingResult result) {

        service.save(company);
    	
    	List<Company> listCompany = service.find();

    	ModelAndView mv = new ModelAndView();
    	
    	mv.setViewName("company");

    	mv.addObject("listCompany", listCompany);        
        mv.addObject("company", new Company());

        return mv;

    }
    
    @RequestMapping(value="/delete", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam("id") Integer id) {
        
        service.delete(Integer.valueOf(id).longValue());

    	List<Company> listCompany = service.find();

    	ModelAndView mv = new ModelAndView();
    	
    	mv.setViewName("company");

    	mv.addObject("listCompany", listCompany);        
        mv.addObject("company", new Company());

        return mv;
        
    }

    @RequestMapping(value="/testCreate", method = RequestMethod.POST)
    public String testCreate(@RequestParam("name") String name) {
        
    	Company company = new Company();
    	company.setName(name);
    	
    	service.save(company);
    	
    	logger.info("company created");
    	
        return "OK";
        
    }

}