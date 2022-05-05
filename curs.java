import java.util.UUID;

public class curs {
    private String id, nume, id_profesor;
    private int an;
    private static int nr_cursuri = 0;

    private curs (curs_builder builder) {
        this.id = builder.id;
        this.nume = builder.nume;
        this.id_profesor = builder.id_profesor;
        this.an = builder.an;
    }

    public String getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getIdProfesor() {
        return id_profesor;
    }

    public void setIdProfesor(String id_profesor) {
        this.id_profesor = id_profesor;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public static int getNrCursuri() {
        return nr_cursuri;
    }

    public static void incrementCursuri() {
        nr_cursuri++;
    }

    public static void decrementCursuri() {
        nr_cursuri--;
    }

    public curs() {
        id = UUID.randomUUID().toString();
        id = id.replace("-", "");
    }

    @Override
    public String toString() {
        return "Curs: " + this.id + " " + this.nume + " Anul: " + this .an + " Profesor: " + this.id_profesor;
    }

    public static class curs_builder {
        private String id, nume, id_profesor;
        private int an;

        public curs_builder(String nume, String id_profesor, int an) {
            id = UUID.randomUUID().toString();
            id = id.replace("-", "");

            this.nume = nume;
            this.id_profesor = id_profesor;
            this.an = an;
        }

        public curs build() {
            return new curs(this);
        }
    }
}
