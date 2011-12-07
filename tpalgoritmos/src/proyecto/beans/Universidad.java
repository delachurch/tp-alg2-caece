package proyecto.beans;

import java.util.ArrayList;
import java.util.List;

//Clase Universidad
public class Universidad {

	//Variables Privadas
	private String nombre;
	private List<Carrera> ecarrera;
	private List<Materia> emateria;
	private List<CarreraMateria> ecarreramateria;
	private List<Alumno> ealumno;
	private Cuatrimestre cuatrimestre;
	private List<List<ActaFinal>> eactafinal;
	private List<Promocion> ecriterios;

	//Obtener el Nombre
	public String getNombre() {
		return nombre;
	}
	
	//Asignar el Nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//Obtener la Lista de Carreras
	public List<Carrera> getEcarrera(){
		return ecarrera;
	}
	
	//Obtener la Lista de Materias
	public List<Materia> getEmateria(){
		return emateria;
	}
	
	//Obtener la Lista de CarreraMateria
	public List<CarreraMateria> getEcarreramateria(){
		return ecarreramateria;
	}
	
	//Obtener la Lista de Alumnos
	public List<Alumno> getEalumno() {
		return ealumno;
	}
	
	//Asignar la Lista de Alumnos
	public void setEalumno(List<Alumno> ealumno) {
		this.ealumno = ealumno;
	}
	
	//Obtener el Cuatrimestre
	public Cuatrimestre getCuatrimestre() {
		return cuatrimestre;
	}
	
	//Asignar el Cuatrimestre
	public void setCuatrimestre(Cuatrimestre cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	//Constructor Universidad (con valores)
	public Universidad(String nombre, List<Alumno> ealumno) {
		super();
		this.nombre = nombre;
		this.ealumno = new ArrayList<Alumno>();
		this.cuatrimestre = new Cuatrimestre();
	}
	
	//Iniciar el Cuatrimestre
	public void InicioCuatrimestre(){
		this.cuatrimestre.InicioCuatrimestre();
	}
	
	//Finalizar el Cuatrimestre
	public void FinCuatrimestre(){
		this.cuatrimestre.FinCuatrimestre();
	}
	
	//Iniciar la Cursada
	public void InicioCursada(){
		this.cuatrimestre.InicioCursada();
	}
	
	//Finalizar la Cursada
	public void FinCursada(){
		this.cuatrimestre.FinCursada();
	}
	
	//Solicitar el Titulo de un Alumno perteneciente a una Carrera 
	public boolean SolicitudTitulo(Alumno alumno, Carrera carrera){
		return alumno.SolicitudTitulo(this,carrera);
	}
	
	//Agregar un Listado de Actas de final 
	public void AgregarActaFinal(List<ActaFinal> eactafinal){
		this.eactafinal.add(eactafinal);
	}

    //Agregar una Materia nueva a una Carrera Existente
    public void IngresarActaFinal(String materia, String carrera, int nota){
    	List<ActaFinal> lstacta = new ArrayList<ActaFinal>();
	    for(Alumno a : this.getEalumno()){
	    	for(HistoriaAcademica ha : a.getEhistoriaacademica()){
	    		if(ha.getCarreramateria().getCarrera().equals(carrera) && ha.getCarreramateria().getMateria().equals(materia) && ha.isIscursada()){
	    			ActaFinal af = new ActaFinal(a, ha.getCarreramateria().getCarrera(), ha.getCarreramateria().getMateria() , nota);
					lstacta.add(af);
				}
			}	
		}
		this.AgregarActaFinal(lstacta);	
    }

	
    //Registrar una Nota de una Materia a un Alumno
    public void RegistrarNota(String matricula, String materia, int nota) throws UniversidadException{
    	for (Alumno a : ealumno){
    		if(a.getMatricula().equals(matricula)){
    			for (HistoriaAcademica ha : a.getEhistoriaacademica()){
    						
    				if (ha.getCarreramateria().getMateria().getNombre().equals(materia)) {
    					if (ha.isIsinscripto()){
    						ha.MarcarComoCursada();
    						//Si la Nota cumple con el Criterio de Promocion...
    						if (ha.getCarreramateria().getMateria().getPromocion().Promocionable(ha.getCarreramateria().getMateria(), nota)) ha.MarcarComoPromocionada();
    					}
    					else throw new UniversidadException("Alumno no inscripto a dicha Materia");
    				}
    			}	
    		}
    	}                
    }
    
   
	//Registrar un Alumno en una lista de Carreras
	public void RegistrarAlumno(Alumno alumno, List<String> escarrera){
		alumno.RegistrarAlumno(this, escarrera);
	}
		
	public List<CarreraMateria> PreCorrelativas(Materia m, List<CarreraMateria> list){
		List<CarreraMateria> ecm = new ArrayList<CarreraMateria>();
		for (CarreraMateria cm :  list){
			for (CarreraMateria corr : cm.getCorrelativas()){
				if (corr.getMateria().getNombre().equals(m.getNombre())) ecm.add(cm);
				else PreCorrelativas(m, corr.getCorrelativas()); 				
			}
		}
		return ecm;
	}

	//Inscribe un Alumno existente en una Lista de Materias
	public void InscribirAlumno(Alumno alumno, List<String> esmateria) throws UniversidadException{
		
		List<Materia> emateria = new ArrayList<Materia>();
		
		for (String smateria : esmateria){
			emateria.add(this.getMateriabyName(smateria));
		}
		
		for (Alumno a: this.getEalumno()){
			if (a.getMatricula() == alumno.getMatricula()) {
				 for (Materia m : emateria){
					 
					 for (CarreraMateria cm : this.getEcarreramateria()){
						 if (cm.getMateria().getNombre().equals(m.getNombre())) {
							 a.MarcarInscripcionMateria(m);
						 }
					 }
		 
					 List<CarreraMateria> eprecorr = new ArrayList<CarreraMateria>();
					 PreCorrelativas(m, this.getEcarreramateria());
					 boolean inscripcion = true;
					 for (Carrera c : this.getEcarrera()){
						 for (CarreraMateria cm : eprecorr){
							 if (c.getNombre().equals(cm.getCarrera().getNombre())){
								 for (HistoriaAcademica ha : a.getEhistoriaacademica()){
									 if (!ha.isIscursada()) {
										 inscripcion = false;
									 }
								 }
							 }
						 }
						 if (inscripcion)  a.MarcarInscripcionMateria(m); 
					 }
				 }
			}
		}
	}
	
	//Agregar una Carrera nueva
	public void AgregarCarrera(String nombre){
		Carrera c = new Carrera(nombre);
		this.ecarrera.add(c);
	}
	
	
	//Agregar una Materia nueva a una Carrera Existente
	public void AgregarMateria(ArrayList<String> eparam) throws UniversidadException{
		Materia m = new Materia(eparam.get(1), eparam.get(3));
		m.AgregarMateria(this, eparam);
	}
	
	
	//Agregar un Alumno a la Universidad
	public void AgregarAlumno(ArrayList<String> eparam){
		Alumno a = new Alumno(eparam.get(1), eparam.get(2), eparam.get(3));
		this.ealumno.add(a);
	}
	
	//Obtener un Alumno a partir de su Matricula
	public Alumno getAlumnobyMatricula(String matricula) throws UniversidadException{
		Alumno aux = new Alumno();
		for (Alumno a : this.ealumno){
			if (a.getMatricula().equals(matricula)) {
				aux = a;
			}
		}
		if (aux.getMatricula() == null) throw new UniversidadException("Alumno Inexistente"); 
		else return aux;
	}

	//Obtener una Carrera a partir de su Nombre
	public Carrera getCarrerabyName(String name) throws UniversidadException{
		Carrera aux = new Carrera();
		for (Carrera c : this.ecarrera){
			if (c.getNombre().equals(name)) {
				aux = c;
			}
		}
		if (aux.getNombre() == null) throw new UniversidadException("Carrera Inexistente"); 
		else return aux;
	}
	
	//Obtener una Materia a partir de su Nombre
	public Materia getMateriabyName(String name) throws UniversidadException{
		Materia aux = new Materia(name);
		for (Materia m : this.emateria){
			if (m.getNombre().equals(aux.getNombre())) {
				return aux = m;
			}
		}
		if (aux.getNombre() == null) throw new UniversidadException("Materia Inexistente"); 
		else return aux;
	}
	
	//Obtener una CarreraMateria a partir de una Carrera y una Materia
	public CarreraMateria getCarreraMateriabyCarreraMateria(String carrera, String materia) throws UniversidadException{
		CarreraMateria aux = new CarreraMateria(getCarrerabyName(carrera), getMateriabyName(materia));
		for (CarreraMateria cm : this.ecarreramateria){
			if (cm.getCarrera().equals(aux.getCarrera()) && cm.getMateria().equals(aux.getMateria())) {
				return aux = cm;
			}
		}
		return aux;
	}

	//Constructor de Universidad
	public Universidad(String nombre) {
		super();
		this.nombre = nombre;
		this.ecarrera = new ArrayList<Carrera>();
		this.emateria = new ArrayList<Materia>();
		this.ecarreramateria = new ArrayList<CarreraMateria>();
		this.ealumno = new ArrayList<Alumno>();
		this.cuatrimestre = new Cuatrimestre();
		List<Promocion> ecriteriospromocion = new ArrayList<Promocion>();
		ecriteriospromocion.add(new Promocion());
		ecriteriospromocion.add(new PromocionPar());
		ecriteriospromocion.add(new PromocionImpar());
		ecriteriospromocion.add(new PromocionNormal());
		this.ecriterios = ecriteriospromocion;
	}

	public List<Promocion> getEcriterios() {
		return ecriterios;
	}

	public void setEcriterios(List<Promocion> ecriterios) {
		this.ecriterios = ecriterios;
	}
	
	
}
