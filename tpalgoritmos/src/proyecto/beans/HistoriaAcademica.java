package proyecto.beans;

//Clase HistoriaAcademica
public class HistoriaAcademica extends CarreraMateria {

	//Variables Privadas
	private boolean isinscripto;
	private boolean iscursada;
	private boolean isfinal;
	
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
	
	//Constructor HistoriaAcademia (con informacion)
	public HistoriaAcademica(Carrera carrera, Materia materia) {
		super(carrera, materia);
		this.isinscripto = false;
		this.iscursada = false;
		this.isfinal = false;
	}	
	
	//Constructor HistoriaAcademica
	public void InscripcionMateria(){
		
	}
}

