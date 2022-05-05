public class curs_student {
    protected String id_curs, id_student;
    protected float nota;

    private curs_student(curs_student_builder builder) {
        this.id_curs = builder.id_curs;
        this.id_student = builder.id_student;
        this.nota = builder.nota;
    }

    public String getIdCurs() {
        return id_curs;
    }
    public void setIdCurs(String id_curs) {
        this.id_curs = id_curs;
    }

    public String getIdStudent() {
        return id_student;
    }
    public void setIdStudent(String id_student) {
        this.id_student = id_student;
    }

    // id-ul entitatii este dat de id_curs + id_student
    public String getId() {
        return id_curs + id_student;
    }

    public float getNota() {
        return nota;
    }
    public void setNota(float nota) {
        this.nota = nota;
    }

    public curs_student(String id_student) {
        this.id_student = id_student;
    }

    @Override
    public String toString() {
        return "Student: " + this.id_student + " Curs: " + this.id_curs + " Nota: " + this.nota;
    }

    public float calculateNota() {
        return 0;
    }

    public static class curs_student_builder {
        private String id_curs, id_student;
        private float nota;

        public curs_student_builder(String id_curs, String id_student, float nota) {
            this.id_curs = id_curs;
            this.id_student = id_student;
            this.nota = nota;
        }

        public curs_student build() {
            return new curs_student(this);
        }
    }
}
