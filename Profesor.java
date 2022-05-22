import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Profesor {
    private String id;
    private String nume;
    private String prenume;
    private List<Curs> cursuri = new ArrayList<>();

    private Profesor(profesorBuilder builder) {
        this.id = builder.id;
        this.nume = builder.nume;
        this.prenume = builder.prenume;
    }

    protected static int nrProfesori = 0;

    public String getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public List<Curs> getCursuri() {
        return cursuri;
    }

    public static int getNrProfesori() {
        return nrProfesori;
    }

    public static void incrementProfesori() {
        nrProfesori++;
    }
    public static void decrementProfesori() {
        nrProfesori--;
    }

    public Profesor() {
        id = UUID.randomUUID().toString();
        id = id.replace("-", "");
    }

    public void addCurs(Curs c) {
        cursuri.add(c);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Profesor: " + this.id + " " + this.nume + " " + this.prenume + "\n");
        for (Curs curs : cursuri) {
            output.append(curs.toString()).append("\n");
        }
        return output.toString();
    }

    public static class profesorBuilder {
        private String id;
        private String nume;
        private String prenume;

        public profesorBuilder(@Nullable String id, String nume, String prenume) {
            if (id == null) {
                id = UUID.randomUUID().toString();
                id = id.replace("-", "");
            }

            this.id = id;
            this.nume =  nume;
            this.prenume = prenume;
        }

        public Profesor build() {
            return new Profesor(this);
        }
    }
}
