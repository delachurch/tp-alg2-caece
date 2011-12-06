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
	public void setPromocion() {
		this.promocion = new Promocion();
	}
	
	//Constructor Materia (con valores)
	public Materia(String nombre, String promocion) {
		super();
		this.nombre = nombre;
		switch (promocion) {
		case "PAR" : this.promocion = new PromocionPar(); break;
		case "IMPAR" : this.promocion = new PromocionImpar(); break;
		case "NORMAL" : this.promocion = new PromocionNormal(); break;
		default : this.promocion = new Promocion(); break;
		}
	}
	
	//Constructor Materia (solo con su nombre)
	public Materia(String nombre) {
		super();
		this.nombre = nombre;
	}

	

	
}
