package proyecto.beans;

public class Cuatrimestre {
	
	private boolean isactual;
	private boolean iscursada;
	
	public boolean isIsactual() {
		return isactual;
	}
	public void setIsactual(boolean isactual) {
		this.isactual = isactual;
	}
	public boolean isIscursada() {
		return iscursada;
	}
	public void setIscursada(boolean iscursada) {
		this.iscursada = iscursada;
	}
	
	public Cuatrimestre() {
		super();
		this.isactual = false;
		this.iscursada = false;
	}
	

}
