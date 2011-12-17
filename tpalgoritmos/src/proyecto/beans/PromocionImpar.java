package proyecto.beans;

public class PromocionImpar extends Promocion {

	@Override
	public boolean Promocionable(int nota){
		if ((nota%2)!=0) return true;
		else return false;
	}
	
	public PromocionImpar(){
		super();
	}
}
