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
import ma.fstt.dao.ClientDAO;
import ma.fstt.entities.Client;
import ma.fstt.service.ClientRepository;

/**
 * Servlet implementation class ClientServlet
 */
@WebServlet("/client")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ClientRepository clientDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientServlet() {
		super();
		clientDao = new ClientDAO();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
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
					addClient(request, response);
					break;
				case "delete":
					deleteClient(request, response);
					break;
				case "edit":
					showEditForm(request, response);
					break;
				case "update":
					updateClient(request, response);
					break;
				case "list":
					listClients(request, response);
					break;
				default:
					listClients(request, response);
					break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listClients(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Client> listClient = clientDao.listClients();
		request.setAttribute("listClient", listClient);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ClientList.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("ClientForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		Long codeCli = Long.parseLong(request.getParameter("id"));
		Client existingClient = clientDao.trouverById(codeCli);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ClientForm.jsp");
		request.setAttribute("client", existingClient);
		dispatcher.forward(request, response);
	}

	private void addClient(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String nomCli = request.getParameter("nomCli");
		String prenomCli = request.getParameter("prenomCli");
		String teleCli = request.getParameter("teleCli");
		String adresseCli = request.getParameter("adresseCli");

		Client newClient = new Client(nomCli, prenomCli, teleCli, adresseCli);
		clientDao.addClient(newClient);
		response.sendRedirect("/Atelier1/client?action=list");
	}

	private void updateClient(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		Long codeCli = Long.parseLong(request.getParameter("id"));
		String nomCli = request.getParameter("nomCli");
		String prenomCli = request.getParameter("prenomCli");
		String teleCli = request.getParameter("teleCli");
		String adresseCli = request.getParameter("adresseCli");

		Client newClient = new Client(codeCli, nomCli, prenomCli, teleCli, adresseCli);
		clientDao.updateClient(newClient);
		response.sendRedirect("/Atelier1/client?action=list");
	}

	private void deleteClient(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		Long codeCli = Long.parseLong(request.getParameter("id"));

		Client client = clientDao.trouverById(codeCli);
		clientDao.deleteClient(client);
		response.sendRedirect("/Atelier1/client?action=list");
	}
}
