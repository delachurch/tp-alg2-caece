package proyecto.actions;

import java.util.ArrayList;

import proyecto.beans.*;

//Clase UI
public class UI {
	
	//Variables Privadas
	private ConsoleReader reader;
	private Universidad universidad;
	
	//Menu de Altas con sus respectivas opciones
	public void MenuAltas() throws UniversidadException {
				
		ArrayList<String> res = new ArrayList<String>();
		res = this.reader.getInput();
		
		switch (res.get(1)) {
		case "CARRERA" : this.universidad.AgregarCarrera(res.get(2));
		case "MATERIA" : this.universidad.AgregarMateria(res.get(2),res.get(3), res);
		case "ALUMNO"  : this.universidad.AgregarAlumno(res.get(2), res.get(3), res.get(4));
		default:  System.out.println("No es un OPCION VALIDA");
		} 
		
		
	}
	
	//Menu de Acciones con sus respectivas opciones
	public void MennuAcciones() throws UniversidadException {
		
		ArrayList<String> res = new ArrayList<String>();
		res = this.reader.getInput();
		
		switch (res.get(1)) {
		case "INICIOCUATRIMESTRE" : this.universidad.InicioCuatrimestre();
		case "FINCUATRIMESTRE" : this.universidad.FinCuatrimestre();
		case "INICIOCURSADA"  : this.universidad.InicioCursada();
		case "FINCURSADA"  : this.universidad.FinCursada();
		case "SolicitudTitulo": this.universidad.SolicitudTitulo(this.universidad.getAlumnobyMatricula(res.get(2)),this.universidad.getCarrerabyName(res.get(3)));
		case "ActaDeFinal": this.universidad.FinalActa();
		case "RegistrarAlumno" : this.universidad.RegistrarAlumno(this.universidad.getAlumnobyMatricula(res.get(2)), res);
		default:  System.out.println("No es un OPCION VALIDA");
		}
	}


	
	
}
