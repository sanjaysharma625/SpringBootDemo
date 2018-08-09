package com.test.springboot.controller;

import com.test.springboot.dao.PersonDAO;
import com.test.springboot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
@Controller
public class MainController {
 
    @Autowired
    private PersonDAO personDAO;
 
    @ResponseBody
    @RequestMapping("/")
    public String index() {
    	
    	System.out.println("Hello. This is inside index method of main controller");
        Iterable<Person> all = personDAO.findAll();
        StringBuilder sb = new StringBuilder();
 
        all.forEach(p -> sb.append(p.getFullName() + "<br>"));
 
        return sb.toString();
    }
 
}