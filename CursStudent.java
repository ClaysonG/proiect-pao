public class CursStudent {
    protected String idCurs;
    protected String idStudent;
    protected float nota;

    private CursStudent(cursStudentBuilder builder) {
        this.idCurs = builder.idCurs;
        this.idStudent = builder.idStudent;
        this.nota = builder.nota;
    }

    public String getIdCurs() {
        return idCurs;
    }
    public void setIdCurs(String idCurs) {
        this.idCurs = idCurs;
    }

    public String getIdStudent() {
        return idStudent;
    }
    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    // id-ul entitatii este dat de id_curs + id_student
    public String getId() {
        return idCurs + idStudent;
    }

    public float getNota() {
        return nota;
    }
    public void setNota(float nota) {
        this.nota = nota;
    }

    public CursStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public String toString() {
        return "Student: " + this.idStudent + " Curs: " + this.idCurs + " Nota: " + this.nota;
    }

    public float calculateNota() {
        return 0;
    }

    public static class cursStudentBuilder {
        private String idCurs;
        private String idStudent;
        private float nota;

        public cursStudentBuilder(String idCurs, String idStudent, float nota) {
            this.idCurs = idCurs;
            this.idStudent = idStudent;
            this.nota = nota;
        }

        public CursStudent build() {
            return new CursStudent(this);
        }
    }
}
