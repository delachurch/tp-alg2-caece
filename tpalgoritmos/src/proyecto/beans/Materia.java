package proyecto.beans;
import java.util.ArrayList;

public class Materia {
  private ArrayList<Materia> correlativas; //usamos listas? hashMap no se
	private Long id;
	private String name;
	private Boolean approved;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getApproved() {
		return approved;
	}
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}	
   
  public ArrayList<Materia> getCorrelativas() {
		return correlativas;
	}

	public void setCorrelativas(ArrayList<Materia> correlativas) {
		this.correlativas = correlativas;
	}	 
}
