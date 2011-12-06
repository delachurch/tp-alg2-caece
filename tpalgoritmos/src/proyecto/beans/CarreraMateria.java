package proyecto.beans;

import java.util.ArrayList;
import java.util.List;

//Clase CarreraMateria
public class CarreraMateria {
	
	//Variables Privadas
	private Carrera carrera;
	private Materia materia;
	private List<CarreraMateria> correlativas;

	
	//Obtener Carrera
	public Carrera getCarrera() {
		return carrera;
	}
	
	//Asignar Carrera
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	
	//Obtener Materia
	public Materia getMateria() {
		return materia;
	}
	
	//Asignar Materia
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	
	//Obtener Lista de Correlativas
	public List<CarreraMateria> getCorrelativas() {
		return correlativas;
	}
	
	//Asignar Lista de Correlativas
	public void setCorrelativas(List<CarreraMateria> correlativas) {
		this.correlativas = correlativas;
	}
	

	//Constructor CarreraMateria
	public CarreraMateria(Carrera carrera, Materia materia) {
		super();
		this.carrera = carrera;
		this.materia = materia;
		this.correlativas = new ArrayList<CarreraMateria>();

	}

	
	
	
	

}
