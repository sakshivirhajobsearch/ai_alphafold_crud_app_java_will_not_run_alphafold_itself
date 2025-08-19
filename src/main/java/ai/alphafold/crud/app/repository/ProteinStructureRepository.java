package ai.alphafold.crud.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ai.alphafold.crud.app.model.ProteinStructure;

public interface ProteinStructureRepository extends JpaRepository<ProteinStructure, Long> {
}