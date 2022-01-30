package repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entite.Etudiant;
import util.EntityManagerUtil;
/**
 * Composant dao Etudiant
 * @author tophe
 * @version 1.0
 *
 */
public class EtudiantRepository implements EtudiantRepositoryItf {

	@Override
	public Etudiant read(Long idEtudiant) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		System.out.println("idEtudiant=" + idEtudiant);
		Etudiant etudiant = entityManager.find(Etudiant.class, idEtudiant);	
		entityManager.close();
		return etudiant;
	}
	@Override
	public Etudiant update(Etudiant etudiant) {
		EntityTransaction tx = null;
		EntityManager entityManager = null; 
		Etudiant apprenant = null;
		try {
			entityManager = EntityManagerUtil.getEntityManager(); 
			tx = entityManager.getTransaction();
			tx.begin();
			apprenant = entityManager.merge(etudiant);
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
		return apprenant;
	}
	@Override
	public void delete(Long id) {
		EntityTransaction tx = null;
		EntityManager entityManager = null; 
		try {
			entityManager = EntityManagerUtil.getEntityManager(); 
			tx = entityManager.getTransaction();
			Etudiant entite = entityManager.find(Etudiant.class, id);
			entityManager.remove(entite);
			tx.begin();
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
	public List<Etudiant> readAll() {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();      
		Query query = entityManager.createQuery("select e from Etudiant as e order by e.formation.acronyme desc, e.nom");
		List<Etudiant> etudiants = query.getResultList();
		entityManager.close();
		return etudiants;
	}

	@Override
	public List<Etudiant> readLikeName(String name) {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();      
		Query query = entityManager.createQuery("select e from Etudiant as e where e.nom like :name");
		query.setParameter("chaine", "%" + name + "%");
		List<Etudiant> etudiants = query.getResultList();
		entityManager.close();
		return etudiants;
	}
	
}
