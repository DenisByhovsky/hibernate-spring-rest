package com.byhovsky.fixr.controller;

import com.byhovsky.fixr.model.Account;
import com.byhovsky.fixr.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
public class Controller {

    private AccountServiceImpl accountService;

    @Autowired(required = true)
    @Qualifier(value = "accountService")
    public void setAccountService(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "accounts", method = RequestMethod.GET)
    public String listAccounts(Model model) {
        model.addAttribute("account", new Account());
        model.addAttribute("accounts", this.accountService.getAll());
        return "accounts";
    }

    @RequestMapping(value = "/account/add", method = RequestMethod.POST)
    public String addAccount(@ModelAttribute("account") Account account) {
        if (account.getId() == 0) {
            this.accountService.add(account);
        } else {
            this.accountService.update(account);
        }
        return "redirect:/accounts";
    }

    @RequestMapping("/remove/{id}")
    public String removeAccount(@PathVariable("id") int id) {
        this.accountService.remove(id);
        return "redirect:/accounts";
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("account", this.accountService.getById(id));
        model.addAttribute("accounts", this.accountService.getAll());
        return "accounts";
    }

    @RequestMapping("accountdata/{id}")
    public String accountData(@PathVariable("id") int id, Model model) {
        model.addAttribute("account", this.accountService.getById(id));
        return "accountdata";
    }
}
