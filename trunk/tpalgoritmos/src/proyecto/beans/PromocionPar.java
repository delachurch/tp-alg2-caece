package proyecto.beans;

public class PromocionPar extends Promocion {

	@Override
	public boolean Promocionable(Materia m, int nota){
		if ((nota%2)==0) return true;
		else return false;
	}
	
	public PromocionPar(){
		super();
	}
}
