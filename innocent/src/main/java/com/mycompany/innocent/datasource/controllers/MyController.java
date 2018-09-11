package com.mycompany.innocent.datasource.controllers;

import java.util.List;

import java.util.LinkedList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

    @RequestMapping(value = "/bank")
    @CrossOrigin(allowCredentials = "true")
    public ResponseEntity<List<String>> getList(Model model) {
        List<String> bank = new LinkedList<String>();
        bank.add("Michael: 3550000 €");
        bank.add("Lukas: 15 €");
        bank.add("Philipp: 500 €");
        bank.add("David: 300 €");

        model.addAttribute("bank", bank);
        return new ResponseEntity<List<String>>(bank, HttpStatus.OK);
    }

    @CrossOrigin(allowCredentials = "true")
    @RequestMapping(value = "/bankpage")
    public String index(Model model) {

        List<String> bank = new LinkedList<String>();
        bank.add("Michael: 3550000 €");
        bank.add("Lukas: 15 €");
        bank.add("Philipp: 500 €");
        bank.add("David: 300 €");

        model.addAttribute("bank", bank);

        return "bank";
    }

    @CrossOrigin(allowCredentials = "true")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<String> getTest() {
        return new ResponseEntity<String>("test", HttpStatus.OK);
    }
}
