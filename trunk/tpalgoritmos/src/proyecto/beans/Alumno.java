package proyecto.beans;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

	private String matricula;
	private String nombre;
	private String apellido;
	private List<HistoriaAcademica> ehistoriaacademica;

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public List<HistoriaAcademica> getEhistoriaacademica() {
		return ehistoriaacademica;
	}
	public void setEhistoriaacademica(List<HistoriaAcademica> ehistoriaacademica) {
		this.ehistoriaacademica = ehistoriaacademica;
	}
	
	public Alumno(String matricula, String nombre, String apellido) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.ehistoriaacademica = new ArrayList<HistoriaAcademica>();
	}
	public Alumno() {
		// TODO Auto-generated constructor stub
	}
	
	




}
