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
	
	
	//Iniciar el Cuatrimestre
	public void InicioCuatrimestre(){
		if (!this.isIsactual()) this.setIsactual(true);
		else System.out.println("ERROR - Cuatrimestre ya iniciado");
	}
	
	//Finalizar el Cuatrimestre
	public void FinCuatrimestre(){
		if (this.isIsactual()) this.setIsactual(false);
		else System.out.println("ERROR - Cuatrimestre ya finalizado");
	}
	
	//Iniciar la Cursada
	public void InicioCursada(){
		if (!this.isIscursada()) this.setIscursada(true);
		else System.out.println("ERROR - Cursada ya iniciada");
	}
	
	//Finalizar la Cursada
	public void FinCursada(){
		if (this.isIscursada()) this.setIscursada(false);
		else System.out.println("ERROR - Cursada ya terminado");
	}
	
	//Funcion que determina si el Cuatrimestre está iniciado, en caso contrario muestra un mensaje de error
    public boolean CuatrimestreIniciado(){
    	if (!this.isIsactual()){ 
    		System.out.println("ERROR - El cuatrimestre no está Iniciado!");
			return false;
		}
    	else
    	{ 
    		return true; 
		}
    }
	
	//Constructor Cuatrimestre
	public Cuatrimestre() {
		super();
		this.isactual = false;
		this.iscursada = false;
	}
	

}
