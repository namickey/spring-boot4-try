package com.example.demo.article;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EditArticleController {

    private final ArticleService articleService;
    private final MessageSource messages;

    @GetMapping("/articles/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("editArticleForm", new EditArticleForm(articleService.getById(id)));
        return "articles/edit";
    }

    @PostMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, @Validated EditArticleForm form, BindingResult result,
            RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "articles/edit";
        }
        try {
            Article article = form.toArticle();
            article.setId(id);
            articleService.update(article);
        } catch (OptimisticLockingFailureException e) {
            result.reject(e.getMessage());
            return "articles/edit";
        }
        redirectAttributes.addFlashAttribute("message", messages.getMessage("MI002", null, Locale.getDefault()));
        return "redirect:/articles/" + id;
    }
}
