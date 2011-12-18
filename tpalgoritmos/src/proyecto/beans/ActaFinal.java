package proyecto.beans;

//Clase ActaFinal
public class ActaFinal{

        //Variables Privadas
        private Alumno alumno;
        private Materia materia;
        private int nota;
                

        //Obtener el alumno
        public Alumno getalumno() {
                return alumno;
        }
        
        //Asignar el alumno
        public void setalumno(Alumno alumno) {
                this.alumno = alumno;
        }
        
        //Obtener la materia
        public Materia getmateria() {
                return materia;
        }
        
        //Asignar la materia
        public void setmateria(Materia materia) {
                this.materia = materia;
        }

		public int getNota() {
			return nota;
		}

		public void setNota(int nota) {
			this.nota = nota;
		}

		public ActaFinal(Alumno alumno, Materia materia,
				int nota) {
			super();
			this.alumno = alumno;
			this.materia = materia;
			this.nota = nota;
		}
        
		
		
}