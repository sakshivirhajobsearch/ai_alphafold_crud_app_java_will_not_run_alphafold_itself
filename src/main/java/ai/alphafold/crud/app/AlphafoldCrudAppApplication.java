package ai.alphafold.crud.app;

import java.util.List;

import ai.alphafold.crud.app.dao.ProteinDAO;
import ai.alphafold.crud.app.model.Protein;

public class AlphafoldCrudAppApplication {

	public static void main(String[] args) {
		ProteinDAO dao = new ProteinDAO();

		System.out.println("=== Creating Proteins ===");
		dao.addProtein(new Protein("Hemoglobin", "MVHLTPEEKSAV", "Alpha-helix"));
		dao.addProtein(new Protein("Myoglobin", "GLSDGEWQLVL", "Beta-sheet"));

		System.out.println("=== Reading All Proteins ===");
		List<Protein> proteins = dao.getAllProteins();
		proteins.forEach(p -> System.out
				.println(p.getId() + ": " + p.getName() + " | " + p.getSequence() + " | " + p.getPredictedStructure()));

		System.out.println("=== Updating Protein ===");
		dao.updateProtein(1, "Updated Alpha-helix");

		System.out.println("=== Reading After Update ===");
		dao.getAllProteins()
				.forEach(p -> System.out.println(p.getId() + ": " + p.getName() + " | " + p.getPredictedStructure()));

		System.out.println("=== Deleting Protein with ID 2 ===");
		dao.deleteProtein(2);

		System.out.println("=== Final Protein List ===");
		dao.getAllProteins().forEach(p -> System.out.println(p.getId() + ": " + p.getName()));
	}
}