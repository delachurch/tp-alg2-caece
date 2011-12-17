package proyecto.actions;

import java.util.ArrayList;

import proyecto.beans.*;

//Clase UI
public class UI implements Subscripto{
	
	//Variables Privadas
	private Universidad universidad;
	
	//Constructor UI
	public UI(){
		super();
		
		ConsoleReader MyReader = new ConsoleReader();
		ArrayList<String> res = new ArrayList<String>();
		res = MyReader.getInput();
		
		this.universidad =  new Universidad(res.toString());
		this.universidad.setSubscripto(this);
				
	};
	
  public void EjecutarUI() throws UniversidadException
  {  
      System.out.println("Ingrese nombre Universidad");
      ConsoleReader MyReader = new ConsoleReader();
      ArrayList<String> res = new ArrayList<String>();
      res = MyReader.getInput();
      
      System.out.println(res);
  		while (res.get(0) != "666") {
			
			System.out.println("Ingrese Opcion: ALTA - ACCION ");
			res = MyReader.getInput();
			
      if (res.get(0).equals("ALTA")){
          System.out.println("Ingrese opcion: CARRERA - MATERIA - ALUMNO");
				  this.MenuAltas(MyReader.getInput());
      }
      else if (res.get(0).equals("ACCION")){
      		System.out.println("Ingrese opcion: CARRERA - MATERIA - ALUMNO");
				  this.MenuAltas(MyReader.getInput());
      }
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
		//En caso de que el Cuatrimestre esté iniciado se permitirá realizar otras opciones
		if (this.universidad.getCuatrimestre().CuatrimestreIniciado())
		{
      if (res.get(0).equals("FINCUATRIMESTRE")) this.universidad.FinCuatrimestre();
      else if (res.get(0).equals("INICIOCURSADA")) this.universidad.InicioCursada();
      else if (res.get(0).equals("FINCURSADA")) this.universidad.FinCursada();
      else if (res.get(0).equals("SolicitudTitulo")) this.universidad.SolicitudTitulo(this.universidad.getAlumnobyMatricula(res.get(1)),this.universidad.getCarrerabyName(res.get(2)));     
      else if (res.get(0).equals("ActaDeFinal")) this.universidad.IngresarActaFinal(res.get(1), res.get(2), Integer.parseInt(res.get(3)));
      else if (res.get(0).equals("RegistrarAlumno")) this.universidad.RegistrarAlumno(this.universidad.getAlumnobyMatricula(res.get(1)), res);
      else if (res.get(0).equals("RegistrarNota")) this.universidad.RegistrarNota(res.get(1), res.get(2),Integer.parseInt(res.get(3)));
      else if (res.get(0).equals("InscribirAlumno")) this.universidad.InscribirAlumno(this.universidad.getAlumnobyMatricula(res.get(1)), res);
      else System.out.println("No es un OPCION VALIDA");
      
		}
		else
		{
			//En caso de que el Cuatrimestre no haya iniciado, solo se permitirá inicarlo
      if (res.get(0).equals("INICIOCUATRIMESTRE")) this.universidad.InicioCuatrimestre();
      else System.out.println("No es un OPCION VALIDA");    
			
         /*switch (res.get(0)) {
				case "INICIOCUATRIMESTRE" : this.universidad.InicioCuatrimestre(); break;
				default:  System.out.println("No es un OPCION VALIDA");*/
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
