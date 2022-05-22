public class CursObligatoriu extends CursStudent {
    int procentExamen;
    int procentLaborator;
    int procentSeminar;
    int notaExamen;
    int notaLaborator;
    int notaSeminar;

    public int getProcentExamen() {
        return procentExamen;
    }

    public void setProcentExamen(int procentExamen) {
        this.procentExamen = procentExamen;
    }

    public int getProcentLaborator() {
        return procentLaborator;
    }

    public void setProcentLaborator(int procentLaborator) {
        this.procentLaborator = procentLaborator;
    }

    public int getProcentSeminar() {
        return procentSeminar;
    }

    public void setProcentSeminar(int procentSeminar) {
        this.procentSeminar = procentSeminar;
    }

    public int getNotaExamen() {
        return notaExamen;
    }

    public void setNotaExamen(int notaExamen) {
        this.notaExamen = notaExamen;
    }

    public int getNotaLaborator() {
        return notaLaborator;
    }

    public void setNotaLaborator(int notaLaborator) {
        this.notaLaborator = notaLaborator;
    }

    public int getNotaSeminar() {
        return notaSeminar;
    }

    public void setNotaSeminar(int notaSeminar) {
        this.notaSeminar = notaSeminar;
    }

    public CursObligatoriu(String idStudent) {
        super(idStudent);
    }

    public CursObligatoriu(String idStudent, String idCurs, int procentExamen, int notaExamen,
                           int procentLaborator, int notaLaborator,
                           int procentSeminar, int notaSeminar) {
        super(idStudent);
        this.idCurs = idCurs;
        this.procentExamen = procentExamen;
        this.notaExamen = notaExamen;
        this.procentLaborator = procentLaborator;
        this.notaLaborator = notaLaborator;
        this.procentSeminar = procentSeminar;
        this.notaSeminar = notaSeminar;
    }

    @Override
    public float calculateNota() {
        return procentExamen / 100f * notaExamen + procentLaborator / 100f * notaLaborator + procentSeminar / 100f * notaSeminar;
    }

    @Override
    public String toString() {
        return "Student: " + this.idStudent + " Curs: " + this.idCurs + " Nota finala: " + this.nota +
                " Procent Examen: " + this.procentExamen + " Procent Laborator: " + this.procentLaborator +
                " Procent Seminar: " + this.procentSeminar + " Nota Examen: " + this.notaExamen +
                " Nota Laborator:  " + this.notaLaborator + " Nota Seminar: " + this.notaSeminar;
    }
}
