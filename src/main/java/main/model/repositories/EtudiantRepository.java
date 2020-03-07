package main.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import main.model.entities.Etudiant;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant, String> {

}
