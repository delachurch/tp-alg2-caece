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
	
	//Constructor de Alumno (con informacion)
	public Alumno(String matricula, String nombre, String apellido) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ehistoriaacademica = new ArrayList<HistoriaAcademica>();
	}
	
	
	
	




}
