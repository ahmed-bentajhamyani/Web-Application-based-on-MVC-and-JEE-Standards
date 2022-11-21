package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import ma.fstt.entities.LigneCmd;
import ma.fstt.service.LigneCmdRepository;

@ApplicationScoped
public class LigneCmdDAO implements LigneCmdRepository {

	@Override
	public List<LigneCmd> listLigneCmds() {
		List<LigneCmd> listLigneCmds = new ArrayList<>();
		String sql = "SELECT * FROM ligne_cmd";

		Connection conn = SingletonConnection.getConnection();
		try {

			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Long numLigne = resultSet.getLong("num_ligne");
				int qteCmd = resultSet.getInt("qte_cmd");
				Long numCmd = resultSet.getLong("num_cmd");
				Long codeArt = resultSet.getLong("code_art");

				LigneCmd ligneCmd = new LigneCmd(numLigne, qteCmd, numCmd, codeArt);
				listLigneCmds.add(ligneCmd);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listLigneCmds;
	}

	@Override
	public LigneCmd trouverById(Long numLigne) {
		LigneCmd ligneCmd = null;
		String sql = "SELECT * FROM ligne_cmd WHERE num_ligne = ?";

		Connection conn = SingletonConnection.getConnection();
		try {

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, numLigne);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				int qteCmd = resultSet.getInt("qte_cmd");
				Long numCmd = resultSet.getLong("num_cmd");
				Long codeArt = resultSet.getLong("code_art");

				ligneCmd = new LigneCmd(numLigne, qteCmd, numCmd, codeArt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ligneCmd;
	}

	@Override
	public void addLigneCmd(LigneCmd ligneCmd) {
		String sql = "INSERT INTO ligne_cmd (qte_cmd, num_cmd, code_art) VALUES (?, ?, ?)";

		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, ligneCmd.getQteCmd());
			statement.setLong(2, ligneCmd.getNumCmd());
			statement.setLong(3, ligneCmd.getCodeArt());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateLigneCmd(LigneCmd ligneCmd) {
		String sql = "UPDATE ligne_cmd SET qte_cmd = ?, num_cmd = ?, code_art = ?";
		sql += " WHERE num_ligne = ?";

		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, ligneCmd.getQteCmd());
			statement.setLong(2, ligneCmd.getNumCmd());
			statement.setLong(3, ligneCmd.getCodeArt());
			statement.setLong(4, ligneCmd.getNumLigne());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteLigneCmd(LigneCmd ligneCmd) {
		String sql = "DELETE FROM ligne_cmd WHERE num_ligne = ?";

		Connection conn = SingletonConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, ligneCmd.getNumLigne());

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
