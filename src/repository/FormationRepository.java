package repository;

import java.text.Normalizer.Form;
import java.util.List;

import javax.persistence.*;

import entite.Etudiant;
import entite.Formation;
import util.EntityManagerUtil;

/**
 * Composant dao Formation
 * @author tophe
 * @version 1.0
 *
 */
public class FormationRepository implements FormationRepositoryItf {

	public void create(Formation formation){
		EntityTransaction tx = null;
		EntityManager entityManager = null; 
		try {
			entityManager = EntityManagerUtil.getEntityManager(); 
			tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(formation);
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(entityManager != null) {
				entityManager.close();
			}
		}
	}
	
	@Override
	public List<String> readAllAcronyme() {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();       
		Query req = entityManager.createQuery("SELECT f.acronyme FROM Formation f");
		List<String> acronymes = req.getResultList();
		entityManager.close();
		return acronymes;
	}
	
	@Override
	public Formation readSansEtudiant(String acronyme) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();       
		Formation formation = entityManager.find(Formation.class, acronyme);
		entityManager.close();
		return formation;
	}
	
	@Override
	public Formation readAvecEtudiant(String acronyme) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();       
		Formation formation = entityManager.find(Formation.class, acronyme);
		formation.getEtudiants().size();
		entityManager.close();
		return formation;
	}
	
	@Override
	public Formation update(Formation formation) {
		EntityTransaction tx = null;
		EntityManager entityManager = null; 
		try {
			entityManager = EntityManagerUtil.getEntityManager(); 
			tx = entityManager.getTransaction();
			tx.begin();
			formation = entityManager.merge(formation);
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(entityManager != null) {
				entityManager.close();
			}
		}
		return formation;
	}
	
	@Override
	public void delete(String acronyme) {
		EntityTransaction tx = null;
		EntityManager entityManager = null; 
		try {
			entityManager = EntityManagerUtil.getEntityManager(); 
			tx = entityManager.getTransaction();
			tx.begin();
			Formation formation = entityManager.find(Formation.class, acronyme);
			entityManager.remove(formation);
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(entityManager != null) {
				entityManager.close();
			}
		}		
	}
	
	@Override
	public List<Formation> readAllSansEtudiant(){
		EntityManager entityManager = EntityManagerUtil.getEntityManager();       
		Query req = entityManager.createQuery("select f from Formation f");
		List<Formation> formations = (List<Formation>) req.getResultList();
		entityManager.close();
		return formations;
	}

	@Override
	public Etudiant inscrire(Etudiant etudiant, String acronyme) {
		EntityTransaction tx = null;
		EntityManager entityManager = null;
		try {
			entityManager = EntityManagerUtil.getEntityManager(); 
			tx = entityManager.getTransaction();
			tx.begin();
			Formation formation = entityManager.find(Formation.class, acronyme);	
			entityManager.persist(etudiant);
			etudiant.setFormation(formation);
			tx.commit();
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}
		finally {
			if(entityManager != null) {
				entityManager.close();
			}
		}
		return etudiant;
	}
	
}
