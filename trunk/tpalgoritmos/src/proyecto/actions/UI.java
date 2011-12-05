package proyecto.actions;

import java.util.ArrayList;

import proyecto.beans.*;

//Clase UI
public class UI {
	
	//Variables Privadas
	private Universidad universidad;
	
	//Constructor UI
	public UI(String uninombre){
		super();
		this.universidad =  new Universidad(uninombre);
		
	};
	

	//Menu de Altas con sus respectivas opciones
	public void MenuAltas(ArrayList<String> res) throws UniversidadException {
					
		switch (res.get(0)) {
		case "CARRERA" : this.universidad.AgregarCarrera(res.get(1)); break;
		case "MATERIA" : this.universidad.AgregarMateria(res); break;
		case "ALUMNO"  : this.universidad.AgregarAlumno(res); break;
		default:  {System.out.println("No es un OPCION VALIDA");}
		} 
		
		
	}
	
	//Menu de Acciones con sus respectivas opciones
	public void MenuAcciones(ArrayList<String> res) throws UniversidadException {
		
		switch (res.get(0)) {
		case "INICIOCUATRIMESTRE" : this.universidad.InicioCuatrimestre(); break;
		case "FINCUATRIMESTRE" : this.universidad.FinCuatrimestre(); break;
		case "INICIOCURSADA"  : this.universidad.InicioCursada(); break;
		case "FINCURSADA"  : this.universidad.FinCursada(); break;
		case "SolicitudTitulo": this.universidad.SolicitudTitulo(this.universidad.getAlumnobyMatricula(res.get(1)),this.universidad.getCarrerabyName(res.get(2))); break;
		case "ActaDeFinal": this.universidad.IngresarActaFinal(res.get(1), res.get(2), Integer.parseInt(res.get(3))); break;
		case "RegistrarAlumno" : this.universidad.RegistrarAlumno(this.universidad.getAlumnobyMatricula(res.get(1)), res); break;
		default:  System.out.println("No es un OPCION VALIDA");
		}
	}



	
	
}
