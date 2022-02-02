package service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import entite.Etudiant;
import entite.EtudiantWhithAcronyme;
import entite.Formation;
import entite.Module;
import repository.EtudiantRepositoryItf;
import repository.FormationRepository;
import util.EntityManagerUtil;

/**
 * Composant service. 
 * @author tophe
 * @version 1.0
 *
 */
public class Service implements ServiceItf {
	private FormationRepository formationRepository;
	private EtudiantRepositoryItf etudiantRepository;
	private List<Formation> formations;

	
	/**
	 * Est initialisé avec les composants dao.
	 * @param formationRepository composant dao Formation
	 * @param etudiantRepository composant dao Etudiant
	 */
	public Service(FormationRepository formationRepository, EtudiantRepositoryItf etudiantRepository) {
		formations = new ArrayList<>();
		this.formationRepository = formationRepository;
		this.etudiantRepository = etudiantRepository;
	}

	@Override
	public void create(Formation formation) {
		formationRepository.create(formation);
	}
	
	@Override
	public Formation readSansEtudiant(String acronyme) {
		return formationRepository.readSansEtudiant(acronyme);
	}
	
	@Override
	public void modifier(Formation formation) {
		formationRepository.update(formation);
	}
	
	@Override
	public List<String> readAllAcronyme() {
		return formationRepository.readAllAcronyme();
	}

	@Override
	public void supprimerFormation(String acronyme) {
		formationRepository.delete(acronyme);
	}
	
	private Formation findFormationByAcronyme(String acronyme) {
		for(Formation formation : formations) {
			if(formation.getAcronyme().equals(acronyme))
				return formation;
		}
		return null;
	}

	@Override
	public List<Formation> readAllSansEtudiant() {
		return formationRepository.readAllSansEtudiant();
	}
	
	@Override
	public EtudiantWhithAcronyme readEtudiant(Long id) {
		Etudiant etudiant = etudiantRepository.read(id);
		EtudiantWhithAcronyme etudiantWhithAcronyme = new EtudiantWhithAcronyme(etudiant);
		return etudiantWhithAcronyme;
	}
	
	@Override
	public EtudiantWhithAcronyme inscrire(EtudiantWhithAcronyme ewa) {
		Etudiant etudiant = ewa.getEtudiant();
		String acronyme = ewa.getAcronyme(); 
		System.out.println("inscrire acronyme=" + acronyme);
		formationRepository.inscrire(etudiant, acronyme);
		System.out.println("inscrire etudiant=" + etudiant);
		EtudiantWhithAcronyme etudiantWhithAcronyme = new EtudiantWhithAcronyme(etudiant);
		return etudiantWhithAcronyme;
	}
	@Override
	public Etudiant inscrire(Etudiant etudiant, String acronyme) {
		formationRepository.inscrire(etudiant, acronyme);
		return etudiant;
	}
	
	@Override
	public void supprimerEtudiant(Long id, String acronyme) {
		etudiantRepository.delete(id);
		
	}
	@Override
	public void modifier(EtudiantWhithAcronyme etudiantWhithAcronyme) {
		Etudiant etudiant = etudiantWhithAcronyme.getEtudiant();
		Formation formation = formationRepository.readSansEtudiant(etudiantWhithAcronyme.getAcronyme());
		etudiant.setFormation(formation);
		etudiantRepository.update(etudiant);
	}

	@Override
	public List<EtudiantWhithAcronyme> readAllEtudiantWithAcronyme() {
		List<Etudiant> etudiants = etudiantRepository.readAll();
		List<EtudiantWhithAcronyme> etudiantWhithAcronymes = new ArrayList<>();
		for(int i=0; i<etudiants.size(); i++) {
			etudiantWhithAcronymes.add(new EtudiantWhithAcronyme(etudiants.get(i)));
		}
		return etudiantWhithAcronymes;
	}

	@Override
	public List<EtudiantWhithAcronyme> readLikeName(String name) {
		List<Etudiant> etudiants = etudiantRepository.readLikeName(name);
		List<EtudiantWhithAcronyme> etudiantWhithAcronymes = new ArrayList<>();
		for(int i=0; i<etudiants.size(); i++) {
			etudiantWhithAcronymes.add(new EtudiantWhithAcronyme(etudiants.get(i)));
		}
		return etudiantWhithAcronymes;
	}
	@Override
	public void ajouterModuleFormation(Module module, String acronyme) {
		Formation formation = findFormationByAcronyme(acronyme);
		formation.add(module);
	}
}
