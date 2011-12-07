package proyecto.beans;

import java.util.ArrayList;
import java.util.List;

//Clase Materia
public class Materia {
  
	//Variables Locales
	private String nombre;
	private Promocion promocion;
	
	//Obtener el Nombre
	public String getNombre() {
		return nombre;
	}
	
	//Asignar el Nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//Obtener si está en Promocion
	public Promocion getPromocion() {
		return promocion;
	}
	
	//Asignar si está en Promocion
	public void setPromocion() {
		this.promocion = new Promocion();
	}
	
	//Agregar una Materia nueva a una Carrera Existente
	public void AgregarMateria(Universidad universidad, ArrayList<String> eparam) throws UniversidadException{
		
		if (!universidad.getEmateria().contains(universidad.getMateriabyName(eparam.get(1)))) {
			universidad.getEmateria().add(this);
		}
		
		CarreraMateria cm = new CarreraMateria(universidad.getCarrerabyName(eparam.get(2)),this);
		
		if (eparam.size()==4){
			if (!universidad.getEcarreramateria().contains(universidad.getCarreraMateriabyCarreraMateria(eparam.get(2), eparam.get(1)))) {
				universidad.getEcarreramateria().add(cm);
			}
		}
		else {
			for (int i=4; i <= eparam.size() - 1; i++){
				CarreraMateria cmcorr = new CarreraMateria(universidad.getCarrerabyName(eparam.get(2)), universidad.getMateriabyName(eparam.get(i)));
				ArmarCorrelatividades(cm, universidad.getEcarreramateria(), cmcorr);
			}
		}	
	}
	
	private void ArmarCorrelatividades (CarreraMateria cm, List<CarreraMateria> ecm, CarreraMateria corr){
		for (CarreraMateria cmaux : ecm){
			if (corr.getCarrera()==cmaux.getCarrera() && corr.getMateria()==cmaux.getMateria()){
				cmaux.getCorrelativas().add(cm);
			} else ArmarCorrelatividades(cm, cmaux.getCorrelativas(), corr);
			
		}
	}
	
	//Constructor Materia (con valores)
	public Materia(String nombre, String promocion) {
		super();
		this.nombre = nombre;
		switch (promocion) {
		case "PAR" : this.promocion = new PromocionPar(); break;
		case "IMPAR" : this.promocion = new PromocionImpar(); break;
		case "NORMAL" : this.promocion = new PromocionNormal(); break;
		default : this.promocion = new Promocion(); break;
		}
	}
	
	//Constructor Materia (solo con su nombre)
	public Materia(String nombre) {
		super();
		this.nombre = nombre;
	}

	

	
}
