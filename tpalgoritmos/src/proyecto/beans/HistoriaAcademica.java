package proyecto.beans;

public class HistoriaAcademica extends CarreraMateria {

	private boolean isinscripto;
	private boolean iscursada;
	private boolean isfinal;
	
	public boolean isIscursada() {
		return iscursada;
	}
	public void setIscursada(boolean iscursada) {
		this.iscursada = iscursada;
	}
	public boolean isIsfinal() {
		return isfinal;
	}
	public void setIsfinal(boolean isfinal) {
		this.isfinal = isfinal;
	}
	public boolean isIsinscripto() {
		return isinscripto;
	}
	public void setIsinscripto(boolean isinscripto) {
		this.isinscripto = isinscripto;
	}
	
	public HistoriaAcademica(Carrera carrera, Materia materia) {
		super(carrera, materia);
		this.isinscripto = false;
		this.iscursada = false;
		this.isfinal = false;
	}	
	
	public void InscripcionMateria(){
		
	}
}

