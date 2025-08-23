package ai.alphafold.crud.app.model;

public class Protein {
	private int id;
	private String name;
	private String sequence;
	private String predictedStructure;

	public Protein(int id, String name, String sequence, String predictedStructure) {
		this.id = id;
		this.name = name;
		this.sequence = sequence;
		this.predictedStructure = predictedStructure;
	}

	public Protein(String name, String sequence, String predictedStructure) {
		this.name = name;
		this.sequence = sequence;
		this.predictedStructure = predictedStructure;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSequence() {
		return sequence;
	}

	public String getPredictedStructure() {
		return predictedStructure;
	}

	public void setId(int id) {
		this.id = id;
	}
}