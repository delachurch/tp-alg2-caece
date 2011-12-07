package proyecto.actions;



import java.util.ArrayList;

import proyecto.beans.UniversidadException;



public class MainAction {

	/**
	 * @param args
	 * @throws UniversidadException 
	 */
	public static void main(String[] args) throws UniversidadException {
		
		System.out.println("Ingrese nombre Universidad");
		ConsoleReader MyReader = new ConsoleReader();
		ArrayList<String> res = new ArrayList<String>();
		res = MyReader.getInput();
		
		System.out.println(res);
		
		UI myUI = new UI(res.toString());
		
		
		
		
		while (res.get(0) != "666") {
			
			System.out.println("Ingrese Opcion: ALTA - ACCION ");
			res = MyReader.getInput();
			
			switch (res.get(0)){
			case "ALTA"   : {
				System.out.println("Ingrese opcion: CARRERA - MATERIA - ALUMNO");
				myUI.MenuAltas(MyReader.getInput());
				break;
			}
			case "ACCION" : {
				System.out.println("Ingrese opcion: INICIOCUATRIMESTRE - FINCUATRIMESTRE - INICIOCURSADA - FINCURSADA");
				System.out.println("				SolicitudTitulo - ActaDeFinal - RegistrarAlumno - RegistrarAlumno - RegistrarNota - InscribirAlumno");
				myUI.MenuAcciones(MyReader.getInput());
				break;
			}
			}
	
			
		}
		

	}

}
