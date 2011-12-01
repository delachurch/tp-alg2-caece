package proyecto.beans;

import java.util.ArrayList;
import java.util.List;

public class CarreraMateria {
	
	private Carrera carrera;
	private Materia materia;
	private List<CarreraMateria> correlativas;

	
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public List<CarreraMateria> getCorrelativas() {
		return correlativas;
	}
	public void setCorrelativas(List<CarreraMateria> correlativas) {
		this.correlativas = correlativas;
	}

	
	public CarreraMateria(Carrera carrera, Materia materia) {
		super();
		this.carrera = carrera;
		this.materia = materia;
		this.correlativas = new ArrayList<CarreraMateria>();

	}

	
	
	
	

}
