import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class student {
    private String id, nume, prenume;
    private int an;
    private List<curs_student> cursuri = new ArrayList<>();

    private student (student_builder builder) {
        this.id = builder.id;
        this.an = builder.an;
        this.nume = builder.nume;
        this.prenume = builder.prenume;
    }

    protected static int nr_studenti = 0;

    public String getId() {
        return id;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }
    public String getNume() {
        return nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    public String getPrenume() {
        return prenume;
    }

    public void setAn(int an) {
        this.an = an;
    }
    public int getAn() {
        return an;
    }

    public List<curs_student> getCursuri() {
        return cursuri;
    }

    public void addCurs(curs_student_factory factory, String id_curs, @Nullable int procent_examen, @Nullable int nota_examen,
                        @Nullable int procent_laborator, @Nullable int nota_laborator,
                        @Nullable int procent_seminar, @Nullable int nota_seminar,
                        @Nullable int nota_proiect) {
        curs_student cs = factory.create_curs_student(id, id_curs, procent_examen, nota_examen, procent_laborator, nota_laborator,
                procent_seminar, nota_seminar, nota_proiect);
        cursuri.add(cs);
    }

    public void removeCurs(String id_curs) {
        for (int i = 0; i < cursuri.size(); i++) {
            if (Objects.equals(cursuri.get(i).getIdCurs(), id_curs) && Objects.equals(cursuri.get(i).getIdStudent(), id)) {
                cursuri.remove(cursuri.get(i));
                break;
            }
        }
    }

    public void updateNote() {
        for (curs_student curs_student : cursuri) {
            float nota = curs_student.calculateNota();
            curs_student.setNota(nota);
        }
    }

    public static int getNrStudenti() {
        return nr_studenti;
    }

    static void incrementStudenti() {
        nr_studenti++;
    }
    static void decrementStudenti() {
        nr_studenti--;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Student: " + this.id + " " + this.nume + " " + this.prenume + " anul " + this.an + "\n");
        for (curs_student curs_student : cursuri) {
            output.append(curs_student.toString()).append("\n");
        }
        return output.toString();
    }

    public student() {
        id = UUID.randomUUID().toString();
        id = id.replace("-", "");
    }

    public static class student_builder {
        private String id, nume, prenume;
        private int an;

        public student_builder (String nume, String prenume, int an) {
            id = UUID.randomUUID().toString();
            id = id.replace("-", "");

            this.nume = nume;
            this.prenume = prenume;
            this.an = an;
        }

        public student build() {
            return new student(this);
        }
    }
}
