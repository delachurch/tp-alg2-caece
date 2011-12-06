package proyecto.beans;

import java.util.ArrayList;
import java.util.List;

//Clase Alumno
public class Alumno {

	//Variables Privadas
	private String matricula;
	private String nombre;
	private String apellido;
	private List<HistoriaAcademica> ehistoriaacademica;

	//Obtener la Matricula
	public String getMatricula() {
		return matricula;
	}
	
	//Asignar la Matricula
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	//Obtener el Nombre
	public String getNombre() {
		return nombre;
	}
	
	//Asignar el Nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//Obtener el Apellido
	public String getApellido() {
		return apellido;
	}
	
	//Asignar el Apellido
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	//Obtener la Historia Acad�mica
	public List<HistoriaAcademica> getEhistoriaacademica() {
		return ehistoriaacademica;
	}
	
	//Asignar la Historia Acad�mica
	public void setEhistoriaacademica(List<HistoriaAcademica> ehistoriaacademica) {
		this.ehistoriaacademica = ehistoriaacademica;
	}
	
	//Constructor de Alumno
	public Alumno() {
		// TODO Auto-generated constructor stub
	}
	
	//Registra al Alumno en una lista de Carreras
	//public void RegistrarAlumno(Universidad universidad, Alumno alumno, List<String> escarrera){
	public void RegistrarAlumno(Universidad universidad, List<String> escarrera){
		List<Carrera> ecarrera = new ArrayList<Carrera>();
		for (int i=2; i <= escarrera.size() - 1; i++){
			Carrera cadd = new Carrera(escarrera.get(i));
			ecarrera.add(cadd);
		}
		for (Carrera c : ecarrera) {
			//RegistrarAlumnoCorr(alumno, c, universidad.getEcarreramateria());
			RegistrarAlumnoCorr(universidad, c);
		}
	}
	
	//public void RegistrarAlumnoCorr(Universidad universidad, Alumno alumno, Carrera carrera, List<CarreraMateria> ecm){
	public void RegistrarAlumnoCorr(Universidad universidad, Carrera carrera){
		for(CarreraMateria cm : universidad.getEcarreramateria()){
			if (cm.getCarrera().getNombre().equals(carrera.getNombre())) {
				HistoriaAcademica ha = new HistoriaAcademica(cm);
				this.getEhistoriaacademica().add(ha); 
				RegistrarAlumnoCorr(this, carrera, cm.getCorrelativas());
			}
		}
	}
	
	//Solicitar el Titulo de un Alumno perteneciente a una Carrera 
	public boolean SolicitudTitulo(Universidad universidad, Carrera carrera){
		if (!universidad.getCuatrimestre().isIsactual()){
			boolean carreracompleta = true;
			for (Alumno a: universidad.getEalumno()){
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
	
		
	//Constructor de Alumno (con informacion)
	public Alumno(String matricula, String nombre, String apellido) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ehistoriaacademica = new ArrayList<HistoriaAcademica>();
	}
	
	
	
	




}
