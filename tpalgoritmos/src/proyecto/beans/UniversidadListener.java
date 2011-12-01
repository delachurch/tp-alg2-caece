package proyecto.beans;

import java.util.EventListener;

public interface UniversidadListener extends EventListener{

	public void handle(UniversidadEvent event);
	
}
