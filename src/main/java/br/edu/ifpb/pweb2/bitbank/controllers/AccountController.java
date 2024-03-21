package br.edu.ifpb.pweb2.bitbank.controllers;

import br.edu.ifpb.pweb2.bitbank.models.Account;
import br.edu.ifpb.pweb2.bitbank.models.Customer;
import br.edu.ifpb.pweb2.bitbank.service.AccountService;
import br.edu.ifpb.pweb2.bitbank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;
    @Autowired
    CustomerService customerService;

    @GetMapping("/form")
    public ModelAndView getForm(ModelAndView modelAndView) {
        modelAndView.setViewName("accounts/form");
        modelAndView.addObject("account", new Account(new Customer()));
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(Account account, ModelAndView modelAndView) {
        accountService.save(account);
        modelAndView.setViewName("accounts/list");
        modelAndView.addObject("accounts", accountService.findAll());
        return modelAndView;
    }

    @GetMapping("/list")
    public ModelAndView listAll(ModelAndView modelAndView) {
        modelAndView.addObject("customers", customerService.findAll());
        modelAndView.setViewName("customers/list");
        return modelAndView;
    }

    @RequestMapping("/{id}")
    public ModelAndView getCustomerById(@PathVariable(value = "id") Integer id, ModelAndView modelAndView) {
        modelAndView.addObject("account", accountService.findById(id));
        modelAndView.setViewName("accounts/form");
        return modelAndView;
    }

    @ModelAttribute("allCustomers")
    public List<Customer> getCustomers() {
        return customerService.findAll();
    }
}
