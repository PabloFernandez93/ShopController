package com.example.Shop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/shop/api")


public class ShopController {

    private Article article;

    /*
    private List<Article> articles = Arrays.asList(
        new Article(1, "lamp", "nice lamp", 20.99),
        new Article(2, "table", "nice table", 50.99),
        new Article(3, "chair", "nice chair", 9.99),
        new Article(4, "butter", "delicious butter", 2.50)
);
     */
    private List<Article> articles = new ArrayList<>(){{
        add(new Article(1, "lamp", "nice lamp", 20.99));
        add(new Article(2, "table", "nice table", 50.99));
        add(new Article(3, "chair", "nice chair", 9.99));
        add(new Article(4, "butter", "nice butter", 2.50));
    }};

    @GetMapping("/article")
    Article showArticle() {
        Article article1 = new Article(1, "Lamp", "nice lamp", 20.99);
        return article1;
    }


    @PostMapping("/article")
    Article addArticle(@Valid @RequestBody Article article){

        articles.add(article);
        return article;
    }


    @GetMapping("/articles")
    List<Article> showArticleList() {
        return articles;
    }


    @GetMapping("/article/{id}")
    ResponseEntity<Void> getArticleById(@PathVariable int id) {
        Article placeholder = null;
        for (Article article : articles) {
            if (article.getId() == id) {
                placeholder = article;
                return ResponseEntity.status(200).build();
            }
        } //return placeholder;

        return ResponseEntity.status(404).build();
    }


    @DeleteMapping("/article/{id}")
    ResponseEntity<Void> deleteArticle(@PathVariable int id) {
        Article placeholder = null;
        for (Article article : articles) {
            if (article.getId() == id) {
                placeholder = article;
               }
        }
        if (placeholder != null){
            articles.remove(placeholder);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(428).build();
        //return ResponseEntity.status(428).body("Object ID not found"); we need to set ResponseEntity<Object>
    }


    @PutMapping("/article")
    Article articleUpdate(@Valid @RequestBody Article updatedArticle) {
        Article placeholder = null;
        for (Article article : articles) {
            if (article.getId() == updatedArticle.getId()) {
                placeholder = article;
            }
        }
        if (placeholder != null) {
            articles.remove(placeholder);
            articles.add(updatedArticle);
        }
        return updatedArticle;
    }

}
