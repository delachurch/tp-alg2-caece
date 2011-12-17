package proyecto.actions;

import java.util.ArrayList;

import proyecto.beans.*;

//Clase UI
public class UI implements Subscripto{
	
	//Variables Privadas
	private Universidad universidad;
	
	//Constructor UI
	public UI(String uninombre){
		super();
		this.universidad =  new Universidad(uninombre);
		this.universidad.setSubscripto(this);
		
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
		 * Como Utilizar el Menu...
		 * 
		 CARRERA NOMBRE
		 MATERIA NOMBRE CARRERA CRITERIO MATERIACORRELATIVA MATERIACORRELATIVA...
		 ALUMNO  MATRICULA NOMBRE APELLIDO
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
				case "InscribirAlumno" : this.universidad.InscribirAlumno(this.universidad.getAlumnobyMatricula(res.get(1)), res); break;
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


		@Override
		public void onCarreraNueva(Carrera c) {
			System.out.println(c.getNombre());			
		}
	

	/*
	 * Como utilizar el menu...
	 * 
	 SolicitudTitulo MATRICULAALUMNO CARRERA
	 ActaDeFinal MATERIA CARRERA NOTA
	 RegistrarAlumno MATRICULAALUMNO CARRERA CARRERA...
	 RegistrarNota MATERIA NOTA
	 InscribirAlumno MATRICULAALUMNO MATERIA MATERIA ....
	 
	 */


	
	
	
}
