package ma.fstt.service;

import java.util.List;
import ma.fstt.entities.Client;

public interface ClientRepository {

	List<Client> listClients();

	Client trouverById(Long codeCli);

	void addClient(Client client);

	void updateClient(Client client);

	void deleteClient(Client client);
}
