package proyecto.beans;

public class Materia {
  
	private String nombre;
	private Promocion promocion;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Promocion getPromocion() {
		return promocion;
	}
	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}
	
	public Materia(String nombre, Promocion promocion) {
		super();
		this.nombre = nombre;
		this.promocion = promocion;
	}
	public Materia() {
		// TODO Auto-generated constructor stub
	}
	public Materia(String nombre) {
		super();
		this.nombre = nombre;
	}

	

	
}
