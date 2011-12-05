package proyecto.beans;

import java.util.EventListener;

public interface UniversidadListener extends EventListener{

	public void handle(UniversidadEvent event);
	
}


/*
  EventListenerList xxxListeners = new EventListnerList();
 
 
public void addXXXListener(XXXListener listener) 
{
     xxxListeners.add(XXXListener.class, listener);
}
public void removeXXXListener(XXXListener listener) 
{
     xxxListeners.remove(XXXListener.class, listener);
}
protected void fireXXX(XXXEvent xxxEvent) 
{
     Object[] listeners = xxxListeners.getListenerList();
     // loop through each listener and pass on the event if needed
     Int numListeners = listeners.length;
     for (int i = 0; i<numListeners; i+=2) 
     {
          if (listeners[i]==XXXListener.class) 
          {
               // pass the event to the listeners event dispatch method
                ((XXXListener)listeners[i+1]).dispatchXXX(xxxEvent);
          }            
     }
}
*/