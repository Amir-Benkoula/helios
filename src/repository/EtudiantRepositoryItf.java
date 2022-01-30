package repository;

import java.util.List;

import entite.Etudiant;

/**
 * Interface composant dao Etudiant
 * @author tophe
 * @version 1.0
 *
 */
public interface EtudiantRepositoryItf {
	Etudiant read(Long id);
	Etudiant update(Etudiant etudiant);
	void delete(Long id); 
	List<Etudiant> readAll();
	List<Etudiant> readLikeName(String name);
}
