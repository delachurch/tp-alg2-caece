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
			default:  System.out.println("No es un OPCION VALIDA");
		}
	} 
		
		/*
		 CARRERA NOMBRE
		 MATERIA NOMBRE CARRERA CRITERIO MATERIACORRELATIVA MATERIACORRELATIVA...
		 ALUMON  MATRICULA NOMBRE APELLIDO
		 */
		
	
	//Menu de Acciones con sus respectivas opciones
	public void MenuAcciones(ArrayList<String> res) throws UniversidadException {
		//En caso de que el Cuatrimestre esté iniciado se permitirá realizar otras opciones
		if (this.universidad.getCuatrimestre().CuatrimestreIniciado())
		{
			switch (res.get(0)) {
				case "FINCUATRIMESTRE" : this.universidad.FinCuatrimestre(); break;
				case "INICIOCURSADA"  : this.universidad.InicioCursada(); break;
				case "FINCURSADA"  : this.universidad.FinCursada(); break;
				case "SolicitudTitulo": this.universidad.SolicitudTitulo(this.universidad.getAlumnobyMatricula(res.get(1)),this.universidad.getCarrerabyName(res.get(2))); break;
				case "ActaDeFinal": this.universidad.IngresarActaFinal(res.get(1), res.get(2), Integer.parseInt(res.get(3))); break;
				case "RegistrarAlumno" : this.universidad.RegistrarAlumno(this.universidad.getAlumnobyMatricula(res.get(1)), res); break;
				case "RegistrarNota" : this.universidad.RegistrarNota(res.get(1), res.get(2),Integer.parseInt(res.get(3))); break;
				default:  System.out.println("No es un OPCION VALIDA");
			}
		}
		else
		{
			//En caso de que el Cuatrimestre no haya iniciado, solo se permitirá inicarlo
			switch (res.get(0)) {
				case "INICIOCUATRIMESTRE" : this.universidad.InicioCuatrimestre(); break;
				default:  System.out.println("No es un OPCION VALIDA");
			}
		}
	}
	

	/*
	 SolicitudTitulo MATRICULAALUMNO CARRERA
	 ActaDeFinal MATERIA CARRERA NOTA
	 RegistrarAlumno MATRICULAALUMNO CARRERA CARRERA...
	 RegistrarNota MATERIA NOTA
	 
	 
	TODO:
	1- Actualizar UML (NICO) ésto lo hago mañana en el laburo que estoy al pedo
	2- MOVER LOGICA DE UNIVERSIDAD AL RESTO (NICO) OK - los métodos están migrados y deje comentado el código por las dudas
	3- Testear Metodos q no se probaron(Maxi)
	4- Switchs ON/OFF segun incio/fin cuatrimestre/cursada (NICO) OK - no comments
	 */


	
	
	
}
