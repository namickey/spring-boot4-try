package com.example.demo.account.password;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PasswordController {

    @GetMapping("/account/password/edit")
    public String editForm(Model model) {
        model.addAttribute("account", new Account());
        return "account/password-edit";
    }

    @PostMapping("/account/password/edit")
    public String edit(@ModelAttribute Account account){
        return "account/password-edit";
    }
}
