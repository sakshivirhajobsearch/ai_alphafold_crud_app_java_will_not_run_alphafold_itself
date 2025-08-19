package ai.alphafold.crud.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ai.alphafold.crud.app.model.ProteinStructure;
import ai.alphafold.crud.app.repository.ProteinStructureRepository;

@Service
public class ProteinStructureService {

	private final ProteinStructureRepository repository;

	public ProteinStructureService(ProteinStructureRepository repository) {
		this.repository = repository;
	}

	public ProteinStructure create(ProteinStructure protein) {
		return repository.save(protein);
	}

	public List<ProteinStructure> getAll() {
		return repository.findAll();
	}

	public Optional<ProteinStructure> getById(Long id) {
		return repository.findById(id);
	}

	public ProteinStructure update(Long id, ProteinStructure updated) {
		updated.setId(id);
		return repository.save(updated);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
}