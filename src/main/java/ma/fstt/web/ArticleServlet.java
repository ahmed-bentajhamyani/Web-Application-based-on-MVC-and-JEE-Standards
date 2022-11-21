package ma.fstt.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ma.fstt.dao.ArticleDAO;
import ma.fstt.entities.Article;
import ma.fstt.service.ArticleRepository;

/**
 * Servlet implementation class ArticleServlet
 */
@WebServlet("/article")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject private ArticleRepository articleDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
        articleDao = new ArticleDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action =  request.getParameter("action");
		
		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "add":
				addArticle(request, response);
				break;
			case "delete":
				deleteArticle(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateArticle(request, response);
				break;
			case "list":
				listArticles(request, response);
				break;
			default:
				listArticles(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void listArticles(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Article> listArticle = articleDao.listArticles();
		request.setAttribute("listArticle", listArticle);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ArticleList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("ArticleForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Long codeArt = Long.parseLong(request.getParameter("id"));
		Article existingArticle = articleDao.trouverById(codeArt);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ArticleForm.jsp");
		request.setAttribute("article", existingArticle);
		dispatcher.forward(request, response);
	}

	private void addArticle(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String nomArt = request.getParameter("nomArt");
		String description = request.getParameter("description");
		float prixUnitaire = Float.parseFloat(request.getParameter("prixUnitaire"));
		int qteArt = Integer.parseInt(request.getParameter("qteArt"));

		Article newArticle = new Article(nomArt, description, prixUnitaire, qteArt);
		articleDao.addArticle(newArticle);
		response.sendRedirect("/Atelier1/article?action=list");
	}

	private void updateArticle(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		Long codeArt = Long.parseLong(request.getParameter("id"));
		String nomArt = request.getParameter("nomArt");
		String description = request.getParameter("description");
		float prixUnitaire = Float.parseFloat(request.getParameter("prixUnitaire"));
		int qteArt = Integer.parseInt(request.getParameter("qteArt"));

		Article newArticle = new Article(codeArt, nomArt, description, prixUnitaire, qteArt);
		articleDao.updateArticle(newArticle);
		response.sendRedirect("/Atelier1/article?action=list");
	}

	private void deleteArticle(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		Long codeArt = Long.parseLong(request.getParameter("id"));

		Article Article = articleDao.trouverById(codeArt);
		articleDao.deleteArticle(Article);
		response.sendRedirect("/Atelier1/article?action=list");
	}
}
