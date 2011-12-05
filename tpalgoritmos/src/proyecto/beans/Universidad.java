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

	//Obtener el Nombre
	public String getNombre() {
		return nombre;
	}
	
	//Asignar el Nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		cuatrimestre.setIsactual(true); 
	}
	
	//Finalizar el Cuatrimestre
	public void FinCuatrimestre(){
		cuatrimestre.setIsactual(false);
	}
	
	//Iniciar la Cursada
	public void InicioCursada(){
		cuatrimestre.setIscursada(true);
	}
	
	//Finalizar la Cursada
	public void FinCursada(){
		cuatrimestre.setIscursada(false);
		//RegistrarNotas
	}
	
	//Solicitar el Titulo de un Alumno perteneciente a una Carrera 
	public boolean SolicitudTitulo(Alumno alumno, Carrera carrera){
		if (!this.cuatrimestre.isIsactual()){
			boolean carreracompleta = true;
			for (Alumno a: this.ealumno){
				if (a.getMatricula() == alumno.getMatricula()){
					for (HistoriaAcademica ha : alumno.getEhistoriaacademica()){
						if (!ha.isIsfinal()) {
							carreracompleta = false;
						}
					}
					
				}
			}
			return carreracompleta;
		} else return false;
	}
	
	public void AgregarActaFinal(List<ActaFinal> eactafinal){
		this.eactafinal.add(eactafinal);
	}

    //Agregar una Materia nueva a una Carrera Existente
    public void IngresarActaFinal(String materia, String carrera, int nota){
    	List<ActaFinal> lstacta = new ArrayList<ActaFinal>();
	    for(Alumno a : this.getEalumno()){
	    	for(HistoriaAcademica ha : a.getEhistoriaacademica()){
	    		if(ha.getCarrera().equals(carrera) && ha.getMateria().equals(materia) && ha.isIscursada()){
	    			ActaFinal af = new ActaFinal(a, ha.getCarrera(), ha.getMateria() , nota);
					lstacta.add(af);
				}
			}	
		}
		this.AgregarActaFinal(lstacta);	
    }

	
    public void RegistrarNotas(String matricula, String materia, String carrera, boolean cursada, boolean fiNal){
    	for (Alumno a : ealumno){
    		if(a.getMatricula().equals(matricula)){
    			for (HistoriaAcademica ha : a.getEhistoriaacademica()){
    				if (ha.getMateria().getNombre().equals(materia) && ha.getCarrera().getNombre().equals(carrera)){
    					ha.setIscursada(cursada);
    					ha.setIsfinal(fiNal);
    				}
    			}	
    		}
    	}                
    }
	
	//Registrar un Alumno en una lista de Carreras
	public void RegistrarAlumno(Alumno alumno, List<String> escarrera){
		List<Carrera> ecarrera = new ArrayList<Carrera>();
		for (int i=2; i <= escarrera.size() - 1; i++){
			Carrera cadd = new Carrera(escarrera.get(i));
			ecarrera.add(cadd);
		}
		for (Carrera c : ecarrera) {
			RegistrarAlumnoCorr(alumno, c, this.ecarreramateria);
		}
	}
	
	public void RegistrarAlumnoCorr(Alumno alumno, Carrera carrera, List<CarreraMateria> ecm){
		for(CarreraMateria cm : ecm){
			if (cm.getCarrera().getNombre().equals(carrera.getNombre())) {
				HistoriaAcademica ha = new HistoriaAcademica(cm.getCarrera(),cm.getMateria());
				alumno.getEhistoriaacademica().add(ha); 
				RegistrarAlumnoCorr(alumno, carrera, cm.getCorrelativas());
			}
		}
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
	
	public boolean InscribirAlumno(Alumno alumno, List<Materia> emateria){
		for (Alumno a: this.ealumno){
			if (a.getMatricula() == alumno.getMatricula()) {
				 for (Materia m : emateria){
					 
					 for (CarreraMateria cm : this.ecarreramateria){
						 if (cm.getMateria().getNombre().equals(m.getNombre())) {
							 return true;
						 }
					 }
		 
					 List<CarreraMateria> eprecorr = new ArrayList<CarreraMateria>();
					 PreCorrelativas(m, this.ecarreramateria);
					 boolean inscripcion = true;
					 for (Carrera c : this.ecarrera){
						 for (CarreraMateria cm : eprecorr){
							 if (c.getNombre().equals(cm.getCarrera().getNombre())){
								 for (HistoriaAcademica ha : a.getEhistoriaacademica()){
									 if (!ha.isIscursada()) {
										 inscripcion = false;
									 }
								 }
							 }
						 }
						 if (inscripcion) return inscripcion; 
					 }
				 }
			}
		}
		return false;
	}
	
	//Agregar una Carrera nueva
	public void AgregarCarrera(String nombre){
		Carrera c = new Carrera(nombre);
		this.ecarrera.add(c);
		System.out.println("Se agrego una carrera");
	}
	
	private void ArmarCorrelatividades (CarreraMateria cm, List<CarreraMateria> ecm, CarreraMateria corr){
		for (CarreraMateria cmaux : ecm){
			if (corr.getCarrera()==cmaux.getCarrera() && corr.getMateria()==cmaux.getMateria()){
				cmaux.getCorrelativas().add(cm);
			} else ArmarCorrelatividades(cm, cmaux.getCorrelativas(), corr);
			
		}
	}
	
	//Agregar una Materia nueva a una Carrera Existente
	public void AgregarMateria(ArrayList<String> eparam) throws UniversidadException{
		
		Materia m = new Materia(eparam.get(1));
		if (!this.emateria.contains(getMateriabyName(eparam.get(1)))) {
			this.emateria.add(m);
		}
		
		CarreraMateria cm = new CarreraMateria(this.getCarrerabyName(eparam.get(2)), m);
		
		if (eparam.size()==3){
			if (!this.ecarreramateria.contains(getCarreraMateriabyCarreraMateria(eparam.get(2), eparam.get(1)))) {
				this.ecarreramateria.add(cm);
			}
		}
		else {
			for (int i=3; i <= eparam.size() - 1; i++){
				CarreraMateria cmcorr = new CarreraMateria(this.getCarrerabyName(eparam.get(2)), getMateriabyName(eparam.get(i)));
				ArmarCorrelatividades(cm, this.ecarreramateria, cmcorr);
			}
		}	
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
	
	public CarreraMateria getCarreraMateriabyCarreraMateria(String carrera, String materia) throws UniversidadException{
		CarreraMateria aux = new CarreraMateria(getCarrerabyName(carrera), getMateriabyName(materia));
		for (CarreraMateria cm : this.ecarreramateria){
			if (cm.getCarrera().equals(aux.getCarrera()) && cm.getMateria().equals(aux.getMateria())) {
				return aux = cm;
			}
		}
		return aux;
	}

	public Universidad(String nombre) {
		super();
		this.nombre = nombre;
		this.ecarrera = new ArrayList<Carrera>();
		this.emateria = new ArrayList<Materia>();
		this.ecarreramateria = new ArrayList<CarreraMateria>();
		this.ealumno = new ArrayList<Alumno>();
		this.cuatrimestre = new Cuatrimestre();
	}
	
	
}
