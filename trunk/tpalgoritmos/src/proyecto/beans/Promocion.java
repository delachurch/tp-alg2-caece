package proyecto.beans;

//Clase Promocion
public class Promocion {

	//Variables Privadas
	private boolean ispromocion;
	
	//Obtener si est� Promocionada
	public boolean isIspromocion() {
		return ispromocion;
	}
	
	//Asignar si est� Promocionada
	public void setIspromocion(boolean ispromocion) {
		this.ispromocion = ispromocion;
	}
	
	//Constructor Promocion (con valor)
	public Promocion(boolean ispromocion) {
		super();
		this.ispromocion = ispromocion;
	}
	
	public void DeterminarRegimenPromocion(Promocion promocion){
		
	}


	
}
