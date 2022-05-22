public class CursOptional extends CursStudent {

    private int notaProiect;

    public void setNotaProiect(int notaProiect) {
        this.notaProiect = notaProiect;
    }

    public CursOptional(String idStudent) {
        super(idStudent);
    }

    public CursOptional(String idStudent, String idCurs, int notaProiect) {
        super(idStudent);
        this.idCurs = idCurs;
        this.notaProiect = notaProiect;
    }

    @Override
    public float calculateNota() {
        return notaProiect;
    }

    @Override
    public String toString() {
        return "Student: " + this.idStudent + " Curs: " + this.idCurs + " Nota finala: " + this.nota +
                " Nota proiect: " + this.notaProiect;
    }
}
