package ai.alphafold.crud.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ai.alphafold.crud.app.model.ProteinStructure;
import ai.alphafold.crud.app.service.ProteinStructureService;

@RestController
@RequestMapping("/api/proteins")
public class ProteinStructureController {

	private final ProteinStructureService service;

	public ProteinStructureController(ProteinStructureService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<ProteinStructure> create(@RequestBody ProteinStructure protein) {
		return ResponseEntity.ok(service.create(protein));
	}

	@GetMapping
	public List<ProteinStructure> getAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProteinStructure> getById(@PathVariable Long id) {
		return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProteinStructure> update(@PathVariable Long id, @RequestBody ProteinStructure protein) {
		return ResponseEntity.ok(service.update(id, protein));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}