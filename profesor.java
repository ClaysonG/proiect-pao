import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class profesor {
    private String id, nume, prenume;
    private List<curs> cursuri = new ArrayList<>();

    private profesor (profesor_builder builder) {
        this.id = builder.id;
        this.nume = builder.nume;
        this.prenume = builder.prenume;
    }

    protected static int nr_profesori = 0;

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

    public List<curs> getCursuri() {
        return cursuri;
    }

    public static int getNrProfesori() {
        return nr_profesori;
    }

    public static void incrementProfesori() {
        nr_profesori++;
    }
    public static void decrementProfesori() {
        nr_profesori--;
    }

    public profesor() {
        id = UUID.randomUUID().toString();
        id = id.replace("-", "");
    }

    public void addCurs(curs c) {
        cursuri.add(c);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Profesor: " + this.id + " " + this.nume + " " + this.prenume + "\n");
        for (curs curs : cursuri) {
            output.append(curs.toString()).append("\n");
        }
        return output.toString();
    }

    public static class profesor_builder {
        private String id, nume, prenume;

        public profesor_builder(String nume, String prenume) {
            id = UUID.randomUUID().toString();
            id = id.replace("-", "");

            this.nume =  nume;
            this.prenume = prenume;
        }

        public profesor build() {
            return new profesor(this);
        }
    }
}
