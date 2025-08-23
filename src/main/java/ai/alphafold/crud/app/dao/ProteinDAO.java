package ai.alphafold.crud.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ai.alphafold.crud.app.model.Protein;
import ai.alphafold.crud.app.util.DBConnection;

public class ProteinDAO {

	public ProteinDAO() {
		try (Connection conn = DBConnection.connect(); Statement stmt = conn.createStatement()) {
			String sql = "CREATE TABLE IF NOT EXISTS proteins (" + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "name TEXT NOT NULL," + "sequence TEXT NOT NULL," + "predicted_structure TEXT NOT NULL)";
			stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addProtein(Protein protein) {
		String sql = "INSERT INTO proteins(name, sequence, predicted_structure) VALUES (?, ?, ?)";
		try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, protein.getName());
			pstmt.setString(2, protein.getSequence());
			pstmt.setString(3, protein.getPredictedStructure());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Protein> getAllProteins() {
		List<Protein> proteins = new ArrayList<>();
		String sql = "SELECT * FROM proteins";
		try (Connection conn = DBConnection.connect();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while (rs.next()) {
				proteins.add(new Protein(rs.getInt("id"), rs.getString("name"), rs.getString("sequence"),
						rs.getString("predicted_structure")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return proteins;
	}

	public void updateProtein(int id, String predictedStructure) {
		String sql = "UPDATE proteins SET predicted_structure = ? WHERE id = ?";
		try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, predictedStructure);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteProtein(int id) {
		String sql = "DELETE FROM proteins WHERE id = ?";
		try (Connection conn = DBConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
