package com.example.demo.account;

import java.util.Objects;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PasswordController {

    private final AccountService accountService;

    @GetMapping("/account/password/edit")
    public String editForm(Model model) {
        model.addAttribute("password", new Password());
        return "account/password-edit";
    }

    @PostMapping("/account/password/edit")
    public String edit(@ModelAttribute Password password, Authentication authentication, Model model){
        if (!Objects.equals(password.getNewPassword(), password.getReNewPassword())) {
            model.addAttribute("error", "新しいパスワードと確認用パスワードが一致しません。");
            return "account/password-edit";
        }
        accountService.update(authentication.getName(), password.getNewPassword());
        return "account/password-edit";
    }
}
