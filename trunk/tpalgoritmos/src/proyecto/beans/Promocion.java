package proyecto.beans;

//Clase Promocion
public class Promocion {

	public boolean Promocionable(int nota){
		return false;
	}
	
	public Promocion(){
		
	}

	public static Promocion getPromocionbyName(String promocion) {
       
       if (promocion.equals("PAR) return new PromocionPar();
       if (promocion.equals("IMPAR) return new PromocionImpar();
       if (promocion.equals("NORMAL) return new PromocionNormal();
       else return null;
       
	 		/*switch (promocion) {
	 		case "PAR" : return new PromocionPar(); 
	 		case "IMPAR" : return new PromocionImpar(); 
	 		case "NORMAL" : return new PromocionNormal(); 
	 		default : return null;
	 		}*/
	}		
	 		
}
