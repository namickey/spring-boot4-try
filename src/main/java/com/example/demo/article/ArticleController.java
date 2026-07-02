package com.example.demo.article;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("articles", articleService.findAll());
        return "articles/list";
    }

    @GetMapping("/articles/{id}")
    public String detail(@PathVariable Long id, Model model) {
        model.addAttribute("article", findArticleOrThrow(id));
        return "articles/detail";
    }

    @GetMapping("/articles/new")
    public String newForm(Model model) {
        model.addAttribute("article", new Article());
        return "articles/new";
    }

    @PostMapping("/articles/new")
    public String create(@ModelAttribute Article article) {
        articleService.create(article);
        return "redirect:/articles/" + article.getId();
    }

    @GetMapping("/articles/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("article", findArticleOrThrow(id));
        return "articles/edit";
    }

    @PostMapping("/articles/{id}/edit")
    public String update(@PathVariable Long id, @ModelAttribute Article article) {
        article.setId(id);
        articleService.update(article);
        return "redirect:/articles/" + id;
    }

    @PostMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id) {
        articleService.deleteById(id);
        return "redirect:/";
    }

    private Article findArticleOrThrow(Long id) {
        Article article = articleService.findById(id);
        if (article == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article not found: " + id);
        }
        return article;
    }

}
