import com.sun.istack.internal.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Student {
    private String id;
    private String nume;
    private String prenume;
    private int an;
    private List<CursStudent> cursuri = new ArrayList<>();

    private Student(studentBuilder builder) {
        this.id = builder.id;
        this.an = builder.an;
        this.nume = builder.nume;
        this.prenume = builder.prenume;
    }

    protected static int nrStudenti = 0;

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

    public List<CursStudent> getCursuri() {
        return cursuri;
    }

    public void addCurs(CursStudentFactory factory, String idCurs, @Nullable int procentExamen, @Nullable int notaExamen,
                        @Nullable int procentLaborator, @Nullable int notaLaborator,
                        @Nullable int procentSeminar, @Nullable int notaSeminar,
                        @Nullable int notaProiect) {
        CursStudent cs = factory.createCursStudent(id, idCurs, procentExamen, notaExamen, procentLaborator, notaLaborator,
                procentSeminar, notaSeminar, notaProiect);
        cursuri.add(cs);
    }

    public void addCurs(CursStudent cursStudent) {
        cursuri.add(cursStudent);
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
        for (CursStudent cursStudent : cursuri) {
            float nota = cursStudent.calculateNota();
            cursStudent.setNota(nota);
        }
    }

    public static int getNrStudenti() {
        return nrStudenti;
    }

    static void incrementStudenti() {
        nrStudenti++;
    }
    static void decrementStudenti() {
        nrStudenti--;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("Student: " + this.id + " " + this.nume + " " + this.prenume + " anul " + this.an + "\n");
        for (CursStudent cursStudent : cursuri) {
            output.append(cursStudent.toString()).append("\n");
        }
        return output.toString();
    }

    public Student() {
        id = UUID.randomUUID().toString();
        id = id.replace("-", "");
    }

    public static class studentBuilder {
        private String id;
        private String nume;
        private String prenume;
        private int an;

        public studentBuilder(@Nullable String id, String nume, String prenume, int an) {
            if (id == null) {
                id = UUID.randomUUID().toString();
                id = id.replace("-", "");
            }

            this.id = id;
            this.nume = nume;
            this.prenume = prenume;
            this.an = an;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
