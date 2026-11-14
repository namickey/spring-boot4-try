package com.example.demo.article;

import java.util.Locale;

import org.springframework.context.MessageSource;
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
public class NewArticleController {

    private final ArticleService articleService;
    private final MessageSource messages;

    @GetMapping("/articles/new")
    public String newForm(Model model) {
        model.addAttribute("newArticleForm", new NewArticleForm());
        return "articles/new";
    }

    @PostMapping("/articles/new")
    public String create(@Validated NewArticleForm form, BindingResult result,
        RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "articles/new";
        }
        articleService.create(form.toArticle());
        redirectAttributes.addFlashAttribute("message", messages.getMessage("MI001", null, Locale.getDefault()));
        return "redirect:/";
    }
}
