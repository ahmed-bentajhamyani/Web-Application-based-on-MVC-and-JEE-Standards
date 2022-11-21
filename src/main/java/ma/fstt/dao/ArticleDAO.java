package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import ma.fstt.entities.Article;
import ma.fstt.service.ArticleRepository;

@ApplicationScoped
public class ArticleDAO implements ArticleRepository {

	@Override
	public List<Article> listArticles() {
		List<Article> listArticles = new ArrayList<>();
		String sql = "SELECT * FROM article";

		Connection conn = SingletonConnection.getConnection();
		try {

			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Long codeArt = resultSet.getLong("code_art");
				String nomArt = resultSet.getString("nom_art");
				String description = resultSet.getString("description");
				float prixUnitaire = resultSet.getFloat("prix_unitaire");
				int qteArt = resultSet.getInt("qte_art");

				Article article = new Article(codeArt, nomArt, description, prixUnitaire, qteArt);
				listArticles.add(article);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listArticles;
	}

	@Override
	public Article trouverById(Long codeArt) {
		Article article = null;
		String sql = "SELECT * FROM article WHERE code_art = ?";

		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, codeArt);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String nomArt = resultSet.getString("nom_art");
				String description = resultSet.getString("description");
				float prixUnitaire = resultSet.getFloat("prix_unitaire");
				int qteArt = resultSet.getInt("qte_art");

				article = new Article(codeArt, nomArt, description, prixUnitaire, qteArt);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return article;
	}

	@Override
	public void addArticle(Article article) {
		String sql = "INSERT INTO article (nom_art, description, prix_unitaire, qte_art) VALUES (?, ?, ?, ?)";

		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, article.getNomArt());
			statement.setString(2, article.getDescription());
			statement.setFloat(3, article.getPrixUnitaire());
			statement.setInt(4, article.getQteArt());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateArticle(Article article) {
		String sql = "UPDATE article SET nom_art = ?, description = ?, prix_unitaire = ?, qte_art = ?";
		sql += " WHERE code_art = ?";

		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, article.getNomArt());
			statement.setString(2, article.getDescription());
			statement.setFloat(3, article.getPrixUnitaire());
			statement.setInt(4, article.getQteArt());
			statement.setLong(5, article.getCodeArt());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteArticle(Article article) {
		String sql = "DELETE FROM article WHERE code_art = ?";

		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, article.getCodeArt());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
