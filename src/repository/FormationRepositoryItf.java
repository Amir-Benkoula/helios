package repository;

import java.util.List;

import entite.Etudiant;
import entite.Formation;

/**
 * Interface composant dao Formation
 * @author tophe
 * @version 1.0
 *
 */
public interface FormationRepositoryItf {
	void create(Formation formation);
	List<String> readAllAcronyme();
	Formation readSansEtudiant(String acronyme);
	Formation readAvecEtudiant(String acronyme);
	Formation update(Formation formation);
	void delete(String acronyme);
	List<Formation> readAllSansEtudiant();
	Etudiant inscrire(Etudiant etudiant, String acronyme);
}
