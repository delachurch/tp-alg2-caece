package proyecto.beans;

//Clase Cuatrimestre
public class Cuatrimestre {
	
	//Variables Locales
	private boolean isactual;
	private boolean iscursada;
	
	//Obtener si el Cuatrimestre es el Actual
	public boolean isIsactual() {
		return isactual;
	}
	
	//Asignar si el Cuatrimestre es el Actual
	public void setIsactual(boolean isactual) {
		this.isactual = isactual;
	}
	
	//Obtener si inció la Cursada
	public boolean isIscursada() {
		return iscursada;
	}
	
	//Asignar si se inició la Cursada
	public void setIscursada(boolean iscursada) {
		this.iscursada = iscursada;
	}
	
	//Constructor Cuatrimestre
	public Cuatrimestre() {
		super();
		this.isactual = false;
		this.iscursada = false;
	}
	

}
