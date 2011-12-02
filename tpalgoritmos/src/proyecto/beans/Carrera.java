package proyecto.beans;

//Clase Carrera
public class Carrera {

	//Variables Privadas
	private String nombre;
		

	//Obtener el Nombre
	public String getNombre() {
		return nombre;
	}
	
	//Asignar el Nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//Constructor de Carrera (con datos)
	public Carrera(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	//Constructor de Carrera
	public Carrera() {
		// TODO Auto-generated constructor stub
	}	
	


}
