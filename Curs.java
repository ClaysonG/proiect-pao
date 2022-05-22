import com.sun.istack.internal.Nullable;

import java.util.UUID;

public class Curs {
    private String id;
    private String nume;
    private String idProfesor;
    private int an;
    private static int nrCursuri = 0;

    private Curs(cursBuilder builder) {
        this.id = builder.id;
        this.nume = builder.nume;
        this.idProfesor = builder.idProfesor;
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
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public static int getNrCursuri() {
        return nrCursuri;
    }

    public static void incrementCursuri() {
        nrCursuri++;
    }

    public static void decrementCursuri() {
        nrCursuri--;
    }

    public Curs() {
        id = UUID.randomUUID().toString();
        id = id.replace("-", "");
    }

    @Override
    public String toString() {
        return "Curs: " + this.id + " " + this.nume + " Anul: " + this .an + " Profesor: " + this.idProfesor;
    }

    public static class cursBuilder {
        private String id;
        private String nume;
        private String idProfesor;
        private int an;

        public cursBuilder(@Nullable String id, String nume, String idProfesor, int an) {
            if (id == null) {
                id = UUID.randomUUID().toString();
                id = id.replace("-", "");
            }

            this.id = id;
            this.nume = nume;
            this.idProfesor = idProfesor;
            this.an = an;
        }

        public Curs build() {
            return new Curs(this);
        }
    }
}
