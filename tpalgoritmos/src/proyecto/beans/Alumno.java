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
	
	//Obtener la Historia Académica
	public List<HistoriaAcademica> getEhistoriaacademica() {
		return ehistoriaacademica;
	}
	
	//Asignar la Historia Académica
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
			RegistrarAlumnoCorr(c, universidad.getEcarreramateria());
		}
	}
	
	//public void RegistrarAlumnoCorr(Universidad universidad, Alumno alumno, Carrera carrera, List<CarreraMateria> ecm){
	public void RegistrarAlumnoCorr(Carrera carrera, List<CarreraMateria> ecarreramateria){
		for(CarreraMateria cm : ecarreramateria){
			if (cm.getCarrera().getNombre().equals(carrera.getNombre())) {
				HistoriaAcademica ha = new HistoriaAcademica(cm);
				this.getEhistoriaacademica().add(ha); 
				RegistrarAlumnoCorr(carrera, cm.getCorrelativas());
			}
		}
	}
	
	//Solicitar el Titulo de un Alumno perteneciente a una Carrera 
	public boolean SolicitudTitulo(Universidad universidad, Carrera carrera){
		if (!universidad.getCuatrimestre().isIsactual()){
			boolean carreracompleta = true;
			for (Alumno a: universidad.getEalumno()){
				if (a.getMatricula().equals(this.getMatricula())){
					for (HistoriaAcademica ha : this.getEhistoriaacademica()){
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
	
	public void MarcarInscripcionMateria (Materia materia){
		for (HistoriaAcademica ha : this.getEhistoriaacademica())
			if (materia.getNombre().equals(ha.getCarreramateria().getCarrera().getNombre())){
				ha.setIsinscripto(true);
			}
	}
	
	




}
