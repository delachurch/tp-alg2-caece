package proyecto.beans;

//Clase Materia
public class Materia {
  
	//Variables Locales
	private String nombre;
	private Promocion promocion;
	
	//Obtener el Nombre
	public String getNombre() {
		return nombre;
	}
	
	//Asignar el Nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//Obtener si está en Promocion
	public Promocion getPromocion() {
		return promocion;
	}
	
	//Asignar si está en Promocion
	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}
	
	//Constructor Materia (con valores)
	public Materia(String nombre, Promocion promocion) {
		super();
		this.nombre = nombre;
		this.promocion = promocion;
	}
	
	//Constructor Materia
	public Materia() {
		// TODO Auto-generated constructor stub
	}
	
	//Constructor Materia (solo con su nombre)
	public Materia(String nombre) {
		super();
		this.nombre = nombre;
	}

	

	
}
