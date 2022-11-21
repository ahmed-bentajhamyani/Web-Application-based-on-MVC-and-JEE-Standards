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
import ma.fstt.dao.CommandeDAO;
import ma.fstt.dao.LigneCmdDAO;
import ma.fstt.entities.Article;
import ma.fstt.entities.Commande;
import ma.fstt.entities.LigneCmd;
import ma.fstt.service.ArticleRepository;
import ma.fstt.service.CommandeRepository;
import ma.fstt.service.LigneCmdRepository;

/**
 * Servlet implementation class LigneCmdServlet
 */
@WebServlet("/lignecmd")
public class LigneCmdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject private LigneCmdRepository ligneCmdDao;
	@Inject private ArticleRepository articleDao;
	@Inject private CommandeRepository commandeDao;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LigneCmdServlet() {
		super();
		ligneCmdDao = new LigneCmdDAO();
		articleDao = new ArticleDAO();
		commandeDao = new CommandeDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action =  request.getParameter("action");
		
		try {
			switch (action) {
			case "new":
				showNewForm(request, response);
				break;
			case "add":
				addLigneCmd(request, response);
				break;
			case "delete":
				deleteLigneCmd(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateLigneCmd(request, response);
				break;
			case "list":
				listLigneCmds(request, response);
				break;
			default:
				listLigneCmds(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void listLigneCmds(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<LigneCmd> listLigneCmd = ligneCmdDao.listLigneCmds();
		request.setAttribute("listLigneCmd", listLigneCmd);

		// All Commandes
		List<Commande> listCommande = commandeDao.listCommandes();
		request.setAttribute("listCommande", listCommande);

		// All Articles
		List<Article> listArticle = articleDao.listArticles();
		request.setAttribute("listArticle", listArticle);

		RequestDispatcher dispatcher = request.getRequestDispatcher("LigneCmdList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("LigneCmdForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Long numCmd = Long.parseLong(request.getParameter("id"));
		LigneCmd existingLigneCmd = ligneCmdDao.trouverById(numCmd);
		RequestDispatcher dispatcher = request.getRequestDispatcher("LigneCmdForm.jsp");
		request.setAttribute("ligneCmd", existingLigneCmd);
		dispatcher.forward(request, response);

	}

	private void addLigneCmd(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int qteCmd = Integer.parseInt(request.getParameter("qteCmd"));
		Long numCmd = Long.parseLong(request.getParameter("numCmd"));
		Long codeArt = Long.parseLong(request.getParameter("codeArt"));

		LigneCmd newLigneCmd = new LigneCmd(qteCmd, numCmd, codeArt);
		ligneCmdDao.addLigneCmd(newLigneCmd);
		response.sendRedirect("/Atelier1/lignecmd?action=list");
	}

	private void updateLigneCmd(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		Long numLigne = Long.parseLong(request.getParameter("id"));
		int qteCmd = Integer.parseInt(request.getParameter("qteCmd"));
		Long numCmd = Long.parseLong(request.getParameter("numCmd"));
		Long codeArt = Long.parseLong(request.getParameter("codeArt"));

		LigneCmd newLigneCmd = new LigneCmd(numLigne, qteCmd, numCmd, codeArt);
		ligneCmdDao.updateLigneCmd(newLigneCmd);
		response.sendRedirect("/Atelier1/lignecmd?action=list");
	}

	private void deleteLigneCmd(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		Long numCmd = Long.parseLong(request.getParameter("id"));

		LigneCmd LigneCmd = ligneCmdDao.trouverById(numCmd);
		ligneCmdDao.deleteLigneCmd(LigneCmd);
		response.sendRedirect("/Atelier1/lignecmd?action=list");
	}
}