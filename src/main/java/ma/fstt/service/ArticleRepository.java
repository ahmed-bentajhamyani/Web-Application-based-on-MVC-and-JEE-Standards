package ma.fstt.service;

import java.util.List;
import ma.fstt.entities.Article;

public interface ArticleRepository {

	List<Article> listArticles();

	Article trouverById(Long codeArt);

	void addArticle(Article article);

	void updateArticle(Article article);

	void deleteArticle(Article article);
}
