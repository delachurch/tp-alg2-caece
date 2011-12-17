package proyecto.beans;

//Clase Promocion
public class Promocion {

	public boolean Promocionable(int nota){
		return false;
	}
	
	public Promocion(){
		
	}

	public static Promocion getPromocionbyName(String promocion) {
	 		switch (promocion) {
	 		case "PAR" : return new PromocionPar(); 
	 		case "IMPAR" : return new PromocionImpar(); 
	 		case "NORMAL" : return new PromocionNormal(); 
	 		default : return null;
	 		}
	}		
	 		
}
