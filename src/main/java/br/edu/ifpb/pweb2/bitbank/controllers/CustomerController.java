package br.edu.ifpb.pweb2.bitbank.controllers;

import br.edu.ifpb.pweb2.bitbank.models.Customer;
import br.edu.ifpb.pweb2.bitbank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/form")
    public String getForm(Customer customer, Model model){
        model.addAttribute("customer", customer);
        return "customers/form";
    }

    @RequestMapping("/save")
    public String save(Customer customer, Model model){
        customerService.save(customer);
        model.addAttribute("customers", customerService.findAll());
        return "customers/list";
    }
}
