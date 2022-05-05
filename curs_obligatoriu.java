public class curs_obligatoriu extends curs_student {
    int procent_examen, procent_laborator, procent_seminar, nota_examen, nota_laborator, nota_seminar;

    public int getProcentExamen() {
        return procent_examen;
    }

    public void setProcentExamen(int procent_examen) {
        this.procent_examen = procent_examen;
    }

    public int getProcentLaborator() {
        return procent_laborator;
    }

    public void setProcentLaborator(int procent_laborator) {
        this.procent_laborator = procent_laborator;
    }

    public int getProcentSeminar() {
        return procent_seminar;
    }

    public void setProcentSeminar(int procent_seminar) {
        this.procent_seminar = procent_seminar;
    }

    public int getNotaExamen() {
        return nota_examen;
    }

    public void setNotaExamen(int nota_examen) {
        this.nota_examen = nota_examen;
    }

    public int getNotaLaborator() {
        return nota_laborator;
    }

    public void setNotaLaborator(int nota_laborator) {
        this.nota_laborator = nota_laborator;
    }

    public int getNotaSeminar() {
        return nota_seminar;
    }

    public void setNotaSeminar(int nota_seminar) {
        this.nota_seminar = nota_seminar;
    }

    public curs_obligatoriu(String id_student) {
        super(id_student);
    }

    public curs_obligatoriu(String id_student, String id_curs, int procent_examen, int nota_examen,
                            int procent_laborator, int nota_laborator,
                            int procent_seminar, int nota_seminar) {
        super(id_student);
        this.id_curs = id_curs;
        this.procent_examen = procent_examen;
        this.nota_examen = nota_examen;
        this.procent_laborator = procent_laborator;
        this.nota_laborator = nota_laborator;
        this.procent_seminar = procent_seminar;
        this.nota_seminar = nota_seminar;
    }

    @Override
    public float calculateNota() {
        return procent_examen / 100f * nota_examen + procent_laborator / 100f * nota_laborator + procent_seminar / 100f * nota_seminar;
    }

    @Override
    public String toString() {
        return "Student: " + this.id_student + " Curs: " + this.id_curs + " Nota finala: " + this.nota +
                " Procent Examen: " + this.procent_examen + " Procent Laborator: " + this.procent_laborator +
                " Procent Seminar: " + this.procent_seminar + " Nota Examen: " + this.nota_examen +
                " Nota Laborator:  " + this.nota_laborator + " Nota Seminar: " + this.nota_seminar;
    }
}
