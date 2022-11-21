package ma.fstt.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.CommandeDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;
import ma.fstt.service.ClientRepository;
import ma.fstt.service.CommandeRepository;

/**
 * Servlet implementation class CommandeServlet
 */
@WebServlet("/commande")
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject private CommandeRepository commandeDao;
	@Inject private ClientRepository clientDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeServlet() {
        super();
        commandeDao = new CommandeDAO();
        clientDao = new ClientDAO();
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
				addCommande(request, response);
				break;
			case "delete":
				deleteCommande(request, response);
				break;
			case "edit":
				showEditForm(request, response);
				break;
			case "update":
				updateCommande(request, response);
				break;
			case "list":
				listCommandes(request, response);
				break;
			default:
				listCommandes(request, response);
				break;
			}
		} catch (SQLException | ParseException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void listCommandes(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Commande> listCommande = commandeDao.listCommandes();
		request.setAttribute("listCommande", listCommande);

		// All Clients
		List<Client> listClient = clientDao.listClients();
		request.setAttribute("listClient", listClient);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CommandeList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("CommandeForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Long numCmd = Long.parseLong(request.getParameter("id"));
		Commande existingCommande = commandeDao.trouverById(numCmd);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CommandeForm.jsp");
		request.setAttribute("commande", existingCommande);
		dispatcher.forward(request, response);

	}

	private void addCommande(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException {
		Date dateCmd = Date.valueOf(request.getParameter("dateCmd"));
		Long codeCli = Long.parseLong(request.getParameter("codeCli"));

		Commande newCommande = new Commande(dateCmd, codeCli);
		commandeDao.addCommande(newCommande);
		response.sendRedirect("/Atelier1/commande?action=list");
	}

	private void updateCommande(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ParseException {
		Long numCmd = Long.parseLong(request.getParameter("id"));
		Date dateCmd = Date.valueOf(request.getParameter("dateCmd"));
		Long codeCli = Long.parseLong(request.getParameter("codeCli"));

		Commande newCommande = new Commande(numCmd, dateCmd, codeCli);
		commandeDao.updateCommande(newCommande);
		response.sendRedirect("/Atelier1/commande?action=list");
	}

	private void deleteCommande(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		Long numCmd = Long.parseLong(request.getParameter("id"));

		Commande Commande = commandeDao.trouverById(numCmd);
		commandeDao.deleteCommande(Commande);
		response.sendRedirect("/Atelier1/commande?action=list");
	}

}
