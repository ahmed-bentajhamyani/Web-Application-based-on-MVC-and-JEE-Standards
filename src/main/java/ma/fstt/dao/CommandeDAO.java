package ma.fstt.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import ma.fstt.entities.Commande;
import ma.fstt.service.CommandeRepository;

@ApplicationScoped
public class CommandeDAO implements CommandeRepository {
	@Override
	public List<Commande> listCommandes() {
		List<Commande> listCommandes = new ArrayList<>();
		String sql = "SELECT * FROM commande";

		Connection conn = SingletonConnection.getConnection();
		try {

			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Long numCmd = resultSet.getLong("num_cmd");
				Date dateCmd = resultSet.getDate("date_cmd");
				Long codeCli = resultSet.getLong("code_cli");

				Commande commande = new Commande(numCmd, dateCmd, codeCli);
				listCommandes.add(commande);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listCommandes;
	}

	@Override
	public Commande trouverById(Long numCmd) {
		Commande commande = null;
		String sql = "SELECT * FROM commande WHERE num_cmd = ?";

		Connection conn = SingletonConnection.getConnection();
		try {

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, numCmd);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				Date dateCmd = resultSet.getDate("date_cmd");
				Long codeCli = resultSet.getLong("code_cli");

				commande = new Commande(numCmd, dateCmd, codeCli);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return commande;
	}

	@Override
	public void addCommande(Commande commande) {
		String sql = "INSERT INTO commande (date_cmd, code_cli) VALUES (?, ?)";

		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDate(1, commande.getDateCmd());
			statement.setLong(2, commande.getCodeCli());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateCommande(Commande commande) {
		String sql = "UPDATE commande SET date_cmd = ?, code_cli = ?";
		sql += " WHERE num_cmd = ?";

		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDate(1, commande.getDateCmd());
			statement.setLong(2, commande.getCodeCli());
			statement.setLong(3, commande.getNumCmd());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCommande(Commande commande) {
		String sql = "DELETE FROM commande WHERE num_cmd = ?";

		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, commande.getNumCmd());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
