package main.model.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.entities.Etudiant;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant, String> {

}
