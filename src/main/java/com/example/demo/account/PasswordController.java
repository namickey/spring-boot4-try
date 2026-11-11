package com.example.demo.account;

import java.util.Objects;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class PasswordController {

    private final AccountService accountService;

    @GetMapping("/account/password/edit")
    public String editForm(Authentication authentication, Model model) {
        Account account = accountService.findByUsername(authentication.getName());
        Password password = new Password();
        password.setVersionNo(account.getVersionNo());
        model.addAttribute("password", password);
        return "account/password-edit";
    }

    @PostMapping("/account/password/edit")
    public String edit(@ModelAttribute Password password, Authentication authentication, Model model,
            RedirectAttributes redirectAttributes, BindingResult result) {
        if (!Objects.equals(password.getNewPassword(), password.getReNewPassword())) {
            model.addAttribute("error", "新しいパスワードと確認用パスワードが一致しません。");
            return "account/password-edit";
        }
        try {
            accountService.update(authentication.getName(), password.getNewPassword(), password.getVersionNo());
        } catch (OptimisticLockingFailureException e){
            result.reject(e.getMessage());
            return "account/password-edit";
        }
        
        redirectAttributes.addFlashAttribute("message", "新しいパスワードへの変更が完了しました。");
        return "redirect:/account/password/edit";
    }
}
