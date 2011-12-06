package proyecto.beans;

//Clase HistoriaAcademica
public class HistoriaAcademica {// extends CarreraMateria {

	//Variables Privadas
	private boolean isinscripto;
	private boolean iscursada;
	private boolean isfinal;
	private int nota;
	private CarreraMateria carreramateria;
	
	//Obtener si está Cursada
	public boolean isIscursada() {
		return iscursada;
	}
	
	//Asignar si está Cursada
	public void setIscursada(boolean iscursada) {
		this.iscursada = iscursada;
	}
	
	//Obtener si está en Final
	public boolean isIsfinal() {
		return isfinal;
	}
	
	//Asignar si está en Final
	public void setIsfinal(boolean isfinal) {
		this.isfinal = isfinal;
	}
	
	//Obtener si se está Inscripto
	public boolean isIsinscripto() {
		return isinscripto;
	}
	
	//Asignar si se está Inscripto
	public void setIsinscripto(boolean isinscripto) {
		this.isinscripto = isinscripto;
	}
	
	public void MarcarComoCursada(){
		this.setIscursada(true);
	}
	
	public void MarcarComoPromocionada(){
		this.setIsfinal(true);
	}
	
	//Constructor HistoriaAcademia (con informacion)
	public HistoriaAcademica(CarreraMateria carreramateria) {
		this.isinscripto = false;
		this.iscursada = false;
		this.isfinal = false;
		this.setCarreramateria(carreramateria);
	}	
	
	public CarreraMateria getCarreramateria() {
		return carreramateria;
	}

	public void setCarreramateria(CarreraMateria carreramateria) {
		this.carreramateria = carreramateria;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
}

