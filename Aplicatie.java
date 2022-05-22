import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Aplicatie {
    private static FileHandler fh = FileHandler.getInstance();
    private static List<Curs> cursuri = new ArrayList<>();
    private static List<Student> studenti = new ArrayList<>();
    private static List<Profesor> profesori = new ArrayList<>();

    public void addCurs(Curs c) throws IOException {
        cursuri.add(c);
        // Adaug cursul profesorului care il tine
        for (int i = 0; i < profesori.size(); i++) {
            if (Objects.equals(profesori.get(i).getId(), c.getIdProfesor())) {
                profesori.get(i).addCurs(c);
                break;
            }
        }
        Curs.incrementCursuri();
        fh.write("cursuri", null, null, c, null, null, null);
        fh.write("audit", null, null, null, null, "inregistrareCurs", String.valueOf(new Timestamp(System.currentTimeMillis())));
    }

    public void removeCurs(String id) {
        for (int i = 0; i < cursuri.size(); i++) {
            if (Objects.equals(id, cursuri.get(i).getId())) {
                cursuri.remove(cursuri.get(i));
                Curs.decrementCursuri();
                return;
            }
        }
    }

    public static List<Curs> getCursuri() {
        return cursuri;
    }

    public void addStudent(Student s) throws IOException {
        studenti.add(s);
        Student.incrementStudenti();
        fh.write("studenti", s, null, null, null, null, null);
        fh.write("audit", null, null, null, null, "inregistrareStudent", String.valueOf(new Timestamp(System.currentTimeMillis())));
    }

    public void removeStudent(String id) {
        for (int i = 0; i < studenti.size(); i++) {
            if (Objects.equals(id, studenti.get(i).getId())) {
                studenti.remove(studenti.get(i));
                Student.decrementStudenti();
                return;
            }
        }
    }

    public static List<Student> getStudenti() {
        return studenti;
    }

    public void addProfesor(Profesor p) throws IOException {
        profesori.add(p);
        Profesor.incrementProfesori();
        fh.write("profesori", null, p, null, null, null, null);
        fh.write("audit", null, null, null, null, "inregistrareProfesor", String.valueOf(new Timestamp(System.currentTimeMillis())));
    }

    public void removeProfesor(String id) {
        for (int i = 0; i < profesori.size(); i++) {
            if (Objects.equals(id, profesori.get(i).getId())) {
                profesori.remove(profesori.get(i));
                Profesor.decrementProfesori();
                return;
            }
        }
    }

    public static List<Profesor> getProfesori() {
        return profesori;
    }

    public static void listStudenti() throws IOException {
        for (Student student : Aplicatie.getStudenti()) {
            System.out.println(student.toString());
        }
        fh.write("audit", null, null, null, null, "citireStudenti", String.valueOf(new Timestamp(System.currentTimeMillis())));
    }

    public static void listProfesori() throws IOException {
        for (Profesor profesor : Aplicatie.getProfesori()) {
            System.out.println(profesor.toString());
        }
        fh.write("audit", null, null, null, null, "citireProfesori", String.valueOf(new Timestamp(System.currentTimeMillis())));
    }

    public static void listCursuri() throws IOException {
        for (Curs curs : Aplicatie.getCursuri()) {
            System.out.println(curs.toString());
        }
        fh.write("audit", null, null, null, null, "citireCursuri", String.valueOf(new Timestamp(System.currentTimeMillis())));
    }

    public static void listStudentiDupaAn(int an) throws IOException {
        for (Student student : Aplicatie.getStudenti()) {
            if (student.getAn() == an) {
                System.out.println(student.toString());
            }
        }
        fh.write("audit", null, null, null, null, "listareStudentiDupaAn", String.valueOf(new Timestamp(System.currentTimeMillis())));
    }
}
