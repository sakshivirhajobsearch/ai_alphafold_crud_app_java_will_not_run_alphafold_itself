package ai.alphafold.crud.app.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProteinStructure {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String proteinName;
	private String sequence;
	private String predictionConfidence;
	private String predictedStructureFilePath; // e.g., PDB or .mmcif
}
