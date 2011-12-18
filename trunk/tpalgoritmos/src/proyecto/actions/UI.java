package proyecto.actions;

import java.util.ArrayList;

import proyecto.beans.*;

//Clase UI
public class UI implements Subscripto{
	
	//Variables Privadas
	private Universidad universidad;
	
	//Constructor UI
	public UI(){
		
		System.out.println("Ingrese nombre Universidad");
		ConsoleReader MyReader = new ConsoleReader();
		ArrayList<String> res = new ArrayList<String>();
		res = MyReader.getInput();
		
		this.universidad =  new Universidad(res.toString());
		this.universidad.setSubscripto(this);
				
	};
	
  public void EjecutarUI() throws UniversidadException
  {  
      
      ConsoleReader MyReader = new ConsoleReader();
      ArrayList<String> res = new ArrayList<String>();
      
      System.out.println("Ingrese Opcion: ALTA - ACCION ");
      res = MyReader.getInput();
      
      
  		while (res.get(0) != "666") {
					
		      if (res.get(0).equals("ALTA")){
		          System.out.println("Ingrese opcion: CARRERA - MATERIA - ALUMNO");
						  this.MenuAltas(MyReader.getInput());
		      }
		      else if (res.get(0).equals("ACCION")){
		      		System.out.println("Ingrese opcion: INICIO(FIN)CUATRIMESTRE/ INICIO(FIN)CURSADA / RegistrarAlumno / InscribirAlumno / RegistrarNota / ActaDeFinal / SolicitudTitulo");
						  this.MenuAcciones(MyReader.getInput());
		      }
		      
		      System.out.println("Ingrese Opcion: ALTA - ACCION ");
				res = MyReader.getInput();
  	}
  }

	//Menu de Altas con sus respectivas opciones
	public void MenuAltas(ArrayList<String> res) throws UniversidadException {
	
    if (res.get(0).equals("CARRERA")) this.universidad.AgregarCarrera(res.get(1));
    else if (res.get(0).equals("MATERIA")) this.universidad.AgregarMateria(res);
    else if (res.get(0).equals("ALUMNO")) this.universidad.AgregarAlumno(res);
    else System.out.println("No es un OPCION VALIDA");
		
     
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
		
		
		if (res.get(0).equals("INICIOCUATRIMESTRE")) this.universidad.InicioCuatrimestre();
		else if (res.get(0).equals("SolicitudTitulo")) this.universidad.SolicitudTitulo(this.universidad.getAlumnobyMatricula(res.get(1)),this.universidad.getCarrerabyName(res.get(2)));
		else if (this.universidad.getCuatrimestre().CuatrimestreIniciado())
					{if (res.get(0).equals("FINCUATRIMESTRE")) this.universidad.FinCuatrimestre();
				      else if (res.get(0).equals("INICIOCURSADA")) this.universidad.InicioCursada();
				      else if (res.get(0).equals("FINCURSADA")) this.universidad.FinCursada();		           
				      else if (res.get(0).equals("ActaDeFinal")) this.universidad.IngresarActaFinal(res.get(1), res.get(2), Integer.parseInt(res.get(3)));
				      else if (res.get(0).equals("RegistrarAlumno")) this.universidad.RegistrarAlumno(this.universidad.getAlumnobyMatricula(res.get(1)), res);
				      else if (res.get(0).equals("RegistrarNota")) this.universidad.RegistrarNota(res.get(1), res.get(2),Integer.parseInt(res.get(3)));
				      else if (res.get(0).equals("InscribirAlumno")) this.universidad.InscribirAlumno(this.universidad.getAlumnobyMatricula(res.get(1)), res);
				      else System.out.println("No es un OPCION VALIDA");
					}
		 	   else	System.out.println("No es un OPCION VALIDA"); 
	}
	
	/*
	 * Como utilizar el menu...
	 * 
	 SolicitudTitulo MATRICULAALUMNO CARRERA
	 ActaDeFinal MATERIA MATRICULAALUMNO NOTA
	 RegistrarAlumno MATRICULAALUMNO CARRERA CARRERA...
	 RegistrarNota MATRICULAALUMNO MATERIA NOTA
	 InscribirAlumno MATRICULAALUMNO MATERIA MATERIA ....
	 
	 */


		@Override
		public void onCarreraNueva(Carrera c) {
			System.out.println("Carrera Agregada : " + c.getNombre());			
		}

		@Override
		public void onAlumnoNuevo(Alumno a) {
			System.out.println("Alumno Agregado " + a.getMatricula());
		}
	
		@Override
		public void onMateriaNueva(Materia m) {
			System.out.println("Materia Agregada " + m.getNombre());
		}
		
		@Override
		public void onSolicitudTitulo(boolean titulo) {
			System.out.println("Titulo Entregado: " + titulo);
		}


	
	
	
}
