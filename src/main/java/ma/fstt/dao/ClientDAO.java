package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import ma.fstt.entities.Client;
import ma.fstt.service.ClientRepository;

@ApplicationScoped
public class ClientDAO implements ClientRepository {
	@Override
	public List<Client> listClients() {
		List<Client> listClients = new ArrayList<>();
		String sql = "SELECT * FROM client";

		Connection conn = SingletonConnection.getConnection();
		try {

			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Long codeCli = resultSet.getLong("code_cli");
				String nomCli = resultSet.getString("nom_cli");
				String prenomCli = resultSet.getString("prenom_cli");
				String teleCli = resultSet.getString("tele_cli");
				String adresseCli = resultSet.getString("adresse_cli");

				Client client = new Client(codeCli, nomCli, prenomCli, teleCli, adresseCli);
				listClients.add(client);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listClients;
	}

	@Override
	public Client trouverById(Long codeCli) {
		Client client = null;
		String sql = "SELECT * FROM client WHERE code_cli = ?";

		Connection conn = SingletonConnection.getConnection();
		try {

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, codeCli);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String nomCli = resultSet.getString("nom_cli");
				String prenomCli = resultSet.getString("prenom_cli");
				String teleCli = resultSet.getString("tele_cli");
				String adresseCli = resultSet.getString("adresse_cli");

				client = new Client(codeCli, nomCli, prenomCli, teleCli, adresseCli);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return client;
	}

	@Override
	public void addClient(Client client) {
		String sql = "INSERT INTO client (nom_cli, prenom_cli, tele_cli, adresse_cli) VALUES (?, ?, ?, ?)";

		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, client.getNomCli());
			statement.setString(2, client.getPrenomCli());
			statement.setString(3, client.getTeleCli());
			statement.setString(4, client.getAdresseCli());
			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateClient(Client client) {
		String sql = "UPDATE client SET nom_cli = ?, prenom_cli = ?, tele_cli = ?, adresse_cli = ?";
		sql += " WHERE code_cli = ?";

		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, client.getNomCli());
			statement.setString(2, client.getPrenomCli());
			statement.setString(3, client.getTeleCli());
			statement.setString(4, client.getAdresseCli());
			statement.setLong(5, client.getCodeCli());
			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteClient(Client client) {
		String sql = "DELETE FROM client WHERE code_cli = ?";

		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, client.getCodeCli());
			
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
