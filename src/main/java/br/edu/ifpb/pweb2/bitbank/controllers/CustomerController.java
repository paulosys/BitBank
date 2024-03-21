package br.edu.ifpb.pweb2.bitbank.controllers;

import br.edu.ifpb.pweb2.bitbank.models.Customer;
import br.edu.ifpb.pweb2.bitbank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/form")
    public ModelAndView getForm(Customer customer, ModelAndView modelAndView){
        modelAndView.addObject("customer", customer);
        modelAndView.setViewName("customers/form");
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(Customer customer, ModelAndView modelAndView){
        customerService.save(customer);
        modelAndView.addObject("customers", customerService.findAll());
        modelAndView.setViewName("redirect:/customers/list");
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView list(ModelAndView modelAndView){
        modelAndView.addObject("customers", customerService.findAll());
        modelAndView.setViewName("customers/list");
        return modelAndView;
    }
}
