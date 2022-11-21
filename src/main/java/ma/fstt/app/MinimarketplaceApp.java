package ma.fstt.app;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.CommandeDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;

public class MinimarketplaceApp {
	public static void main(String[] args) throws SQLException {
		ClientDAO clientDao = new ClientDAO();

		Client client1 = new Client((long) 1, "Bentaj", "Ahmed", "0622365058", "Anassi 2");
		// clientDao.addClient(client1);
		
		// clientDao.deleteClient(client1);
		
		List<Client> clients = clientDao.listClients();
		for (Client c : clients)
			System.out.println(c.getCodeCli());

		CommandeDAO commandeDao = new CommandeDAO();

		Date date = new Date(3045600);   
		Commande commande1 = new Commande(date, (long) 2);
		commandeDao.addCommande(commande1);
	}
}
