package entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/**
 * Classe m�tier formation. Association Formation/Etudiant bidirectionnelle.
 * @author tophe
 * @version 1.0
 *
 */
@Entity
public class Formation implements Serializable {
	@Id
	private String acronyme;  
	private String intitule;
	private List<Module> modules;
	@OneToMany(mappedBy="formation", cascade = CascadeType.ALL)
	@OrderBy("nom ASC")
	private List<Etudiant> etudiants; 
	private int nbrHeure;
	@Lob
	private String description;
	public Formation(){
		etudiants = new ArrayList<>();
	}
	public Formation(String acronyme, String intitule, int nbrHeure) {
		this.acronyme = acronyme;
		this.intitule = intitule;
		this.nbrHeure = nbrHeure;
		etudiants = new ArrayList<>();
	}
	public void add(Etudiant etudiant) {
		etudiants.add(etudiant);
	}
	public void add(Module module) {
		modules.add(module);
	}
	public void suppr(Etudiant etudiant) {
		for(int i=0; i<etudiants.size(); i++) {
			if(etudiants.get(i).getId().equals(etudiant.getId()))
				etudiants.remove(etudiants.get(i));
		}
	}
	@Override
	public String toString() {
		return "Formation [acronyme=" + acronyme + ", intitule=" + intitule + ", nbrHeure=" + nbrHeure + "]";
	}
	public String getAcronyme() {
		return acronyme;
	}
	public void setAcronyme(String acronyme) {
		this.acronyme = acronyme;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public List<Etudiant> getEtudiants() {
		return etudiants;
	}
	public void setEtudiants(List<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}
	public int getNbrHeure() {
		return nbrHeure;
	}
	public void setNbrHeure(int nbrHeure) {
		this.nbrHeure = nbrHeure;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
}
