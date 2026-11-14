package com.example.demo.account;

import java.util.Locale;
import java.util.Objects;

import org.springframework.context.MessageSource;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EditPasswordController {

    private final AccountService accountService;
    private final PasswordEncoder passwordEncoder;
    private final MessageSource messages;

    @GetMapping("/account/password/edit")
    public String editForm(Authentication authentication, Model model) {
        Account account = accountService.findByUsername(authentication.getName());
        EditPasswordForm form = new EditPasswordForm();
        form.setVersionNo(account.getVersionNo());
        model.addAttribute("editPasswordForm", form);
        return "account/password-edit";
    }

    @PostMapping("/account/password/edit")
    public String edit(@Validated EditPasswordForm form, BindingResult result, Authentication authentication,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "account/password-edit";
        }

        try {
            Account account = form.toAccount();
            account.setUsername(authentication.getName());
            account.setPassword(passwordEncoder.encode(form.getNewPassword()));
            accountService.updatePassword(account);
        } catch (OptimisticLockingFailureException e) {
            result.reject(e.getMessage());
            return "account/password-edit";
        }

        redirectAttributes.addFlashAttribute("message", messages.getMessage("MI004", null, Locale.getDefault()));
        return "redirect:/account/password/edit";
    }
}
