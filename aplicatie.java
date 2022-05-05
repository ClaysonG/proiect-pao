import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class aplicatie {
    private List<curs> cursuri = new ArrayList<>();
    private List<student> studenti = new ArrayList<>();
    private List<profesor> profesori = new ArrayList<>();

    public void addCurs(curs c) {
        cursuri.add(c);
        // Adaug cursul profesorului care il tine
        for (int i = 0; i < profesori.size(); i++) {
            if (Objects.equals(profesori.get(i).getId(), c.getIdProfesor())) {
                profesori.get(i).addCurs(c);
                break;
            }
        }
        curs.incrementCursuri();
    }

    public void removeCurs(String id) {
        for (int i = 0; i < cursuri.size(); i++) {
            if (Objects.equals(id, cursuri.get(i).getId())) {
                cursuri.remove(cursuri.get(i));
                curs.decrementCursuri();
                return;
            }
        }
    }

    public List<curs> getCursuri() {
        return cursuri;
    }

    public void addStudent(student s) {
        studenti.add(s);
        student.incrementStudenti();
    }

    public void removeStudent(String id) {
        for (int i = 0; i < studenti.size(); i++) {
            if (Objects.equals(id, studenti.get(i).getId())) {
                studenti.remove(studenti.get(i));
                student.decrementStudenti();
                return;
            }
        }
    }

    public List<student> getStudenti() {
        return studenti;
    }

    public void addProfesor(profesor p) {
        profesori.add(p);
        profesor.incrementProfesori();
    }

    public void removeProfesor(String id) {
        for (int i = 0; i < profesori.size(); i++) {
            if (Objects.equals(id, profesori.get(i).getId())) {
                profesori.remove(profesori.get(i));
                profesor.decrementProfesori();
                return;
            }
        }
    }

    public List<profesor> getProfesori() {
        return profesori;
    }
}
