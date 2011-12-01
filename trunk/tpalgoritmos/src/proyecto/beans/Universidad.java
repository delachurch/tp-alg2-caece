package proyecto.beans;

import java.util.ArrayList;
import java.util.List;

public class Universidad {

	
	private String nombre;
	private List<Carrera> ecarrera;
	private List<Materia> emateria;
	private List<CarreraMateria> ecarreramateria;
	private List<Alumno> ealumno;
	private Cuatrimestre cuatrimestre;

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Alumno> getEalumno() {
		return ealumno;
	}
	public void setEalumno(List<Alumno> ealumno) {
		this.ealumno = ealumno;
	}
	public Cuatrimestre getCuatrimestre() {
		return cuatrimestre;
	}
	public void setCuatrimestre(Cuatrimestre cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	public Universidad(String nombre, List<Alumno> ealumno) {
		super();
		this.nombre = nombre;
		this.ealumno = new ArrayList<Alumno>();
		this.cuatrimestre = new Cuatrimestre();
	}
	
	public void InicioCuatrimestre(){
		cuatrimestre.setIsactual(true); 
	}
	
	public void FinCuatrimestre(){
		cuatrimestre.setIsactual(false);
	}
	
	public void InicioCursada(){
		cuatrimestre.setIscursada(true);
	}
	
	public void FinCursada(){
		cuatrimestre.setIscursada(false);
		//RegistrarNotas
	}
	
	public boolean SolicitudTitulo(Alumno alumno, Carrera carrera){
		//no me gusta
		if (!this.cuatrimestre.isIsactual()){
			boolean carreracompleta = true;
			for (Alumno a: this.ealumno){
				if (a == alumno){
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
	
	public void FinalActa(){
		
		
	}
	
	public void RegistrarAlumno(Alumno alumno, List<String> escarrera){
		List<Carrera> ecarrera = new ArrayList<Carrera>();
		for (int i=3; i <= escarrera.size(); i++){
			Carrera cadd = new Carrera(escarrera.get(i));
			ecarrera.add(cadd);
		}
		for (Carrera c : ecarrera) {
			for(CarreraMateria cm : this.ecarreramateria){
				Carrera auxc = cm.getCarrera();
				if (auxc == c) {
					alumno.getEhistoriaacademica().add((HistoriaAcademica) cm);
				}
			}
		}
	}
	
	
	public void AgregarCarrera(String nombre){
		Carrera c = new Carrera(nombre);
		this.ecarrera.add(c);		
	}
	
	public void AgregarMateria(String nombre, Promocion promocion, Carrera carrera){
		Materia m = new Materia(nombre, promocion);
		this.emateria.add(m);
		CarreraMateria cm = new CarreraMateria(carrera, m);
		this.ecarreramateria.add(cm);		
	}
	
	public void AgregarMateria(String nombre, String carrera, ArrayList<String> ecorrelativapadre) throws UniversidadException{
		Materia m = new Materia(nombre);
		this.emateria.add(m);
		
		for (CarreraMateria cm : this.ecarreramateria){
			Materia auxm = cm.getMateria();
			for (int i=4; i <= ecorrelativapadre.size(); i++){
				if (auxm == getMateriabyName(ecorrelativapadre.get(i))) {
					CarreraMateria auxcm = new CarreraMateria(getCarrerabyName(carrera), m);
					cm.getCorrelativas().add(auxcm);
				}	
			}
		}		
	}
	
	public void AgregarAlumno(String matricula, String nombre, String apellido){
		Alumno a = new Alumno(matricula, nombre, apellido);
		this.ealumno.add(a);
	}
	
	public Alumno getAlumnobyMatricula(String matricula) throws UniversidadException{
		Alumno aux = new Alumno();
		for (Alumno a : this.ealumno){
			if (a.getMatricula().equals(matricula)) {
				aux = a;
			}
		}
		return aux;
	}

	public Carrera getCarrerabyName(String name) throws UniversidadException{
		Carrera aux = new Carrera();
		for (Carrera c : this.ecarrera){
			if (c.getNombre().equals(name)) {
				aux = c;
			}
		}
		return aux;
	}
	
	public Materia getMateriabyName(String name) throws UniversidadException{
		Materia aux = new Materia();
		for (Materia m : this.emateria){
			if (m.getNombre().equals(name)) {
				aux = m;
			}
		}
		return aux;
	}
	
	
}
