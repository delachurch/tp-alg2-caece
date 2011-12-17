package proyecto.beans;

public class PromocionNormal extends Promocion {

	@Override
	public boolean Promocionable(int nota){
		if (nota>=7) return true;
		else return false;
	}
	
	public PromocionNormal(){
		super();
	}
}
