package entite;

public class Module {
	private Long id;
	private String intitule;
	public Module() {}
	public Module(String intitule) {
		super();
		this.intitule = intitule;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
