package com.example.demo.article;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DeleteArticleController {

    private final ArticleService articleService;
    private final MessageSource messages;

    @PostMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, @Validated DeleteArticleForm form, BindingResult result,
            RedirectAttributes redirectAttributes) {
        
        if (result.hasErrors()) {
            return "redirect:/";
        }

        try {
            articleService.deleteById(id, form.getVersionNo());
        } catch (OptimisticLockingFailureException e) {
            redirectAttributes.addFlashAttribute("error",
                    messages.getMessage(e.getMessage(), null, Locale.getDefault()));
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("message", messages.getMessage("MI003", null, Locale.getDefault()));
        return "redirect:/";
    }
}
