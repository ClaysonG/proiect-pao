public class curs_optional extends curs_student {

    private int nota_proiect;

    public void setNotaProiect(int nota_proiect) {
        this.nota_proiect = nota_proiect;
    }

    public curs_optional(String id_student) {
        super(id_student);
    }

    public curs_optional(String id_student, String id_curs, int nota_proiect) {
        super(id_student);
        this.id_curs = id_curs;
        this.nota_proiect = nota_proiect;
    }

    @Override
    public float calculateNota() {
        return nota_proiect;
    }

    @Override
    public String toString() {
        return "Student: " + this.id_student + " Curs: " + this.id_curs + " Nota finala: " + this.nota +
                " Nota proiect: " + this.nota_proiect;
    }
}
