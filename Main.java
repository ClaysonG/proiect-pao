public class Main {
    public static void main(String[] args) {
        try {
            Aplicatie A = new Aplicatie();
            FileHandler fh = FileHandler.getInstance();

            /*
            // Citire:

            fh.read("studenti", A);
            fh.read("profesori", A);
            fh.read("cursuri", A);
            fh.read("cursuriStudenti", A);

            Aplicatie.listStudenti();
            Aplicatie.listProfesori();
            Aplicatie.listCursuri();

            Aplicatie.listStudentiDupaAn(2);
            */

            // Scriere:


            // adaug studenti
            Student s1 = new Student.studentBuilder(null, "Popescu", "Stefan", 1).build();
            Student s2 = new Student.studentBuilder(null, "Ionescu", "Ioan", 1).build();
            Student s3 = new Student.studentBuilder(null, "Pavel", "Ioana", 2).build();
            Student s4 = new Student.studentBuilder(null, "Stoica", "Raluca", 2).build();
            Student s5 = new Student.studentBuilder(null, "Urziceanu", "Mircea", 4).build();
            A.addStudent(s1);
            A.addStudent(s2);
            A.addStudent(s3);
            A.addStudent(s4);
            A.addStudent(s5);
            for (Student student : Aplicatie.getStudenti()) {
                System.out.println(student.toString());
            }
            // adaug profesori
            Profesor p1 = new Profesor.profesorBuilder(null,"Gherman", "Daniel").build();
            Profesor p2 = new Profesor.profesorBuilder(null,"Drilea", "Sergiu").build();
            Profesor p3 = new Profesor.profesorBuilder(null,"Diaconu", "Antonia").build();
            A.addProfesor(p1);
            A.addProfesor(p2);
            A.addProfesor(p3);
            for (Profesor profesor : Aplicatie.getProfesori()) {
                System.out.println(profesor.toString());
            }
            // adaug cursuri
            Curs c1 = new Curs.cursBuilder(null,"Algebra", p1.getId(), 1).build();
            Curs c2 = new Curs.cursBuilder(null,"Analiza", p1.getId(), 1).build();
            Curs c3 = new Curs.cursBuilder(null,"Programare", p2.getId(), 1).build();
            Curs c4 = new Curs.cursBuilder(null,"Electronica", p2.getId(), 2).build();
            Curs c5 = new Curs.cursBuilder(null,"Teoria Sistemelor", p3.getId(), 2).build();
            Curs c6 = new Curs.cursBuilder(null,"Tehnici Web", p3.getId(), 4).build();
            A.addCurs(c1);
            A.addCurs(c2);
            A.addCurs(c3);
            A.addCurs(c4);
            A.addCurs(c5);
            A.addCurs(c6);
            for (Curs curs : Aplicatie.getCursuri()) {
                System.out.println(curs.toString());
            }
            // afisez profesorii (+ cursurile pe care le predau)
            for (Profesor profesor : Aplicatie.getProfesori()) {
                System.out.println(profesor.toString());
            }
            // adaug note studentilor
            CursObligatoriuStudent f1 = new CursObligatoriuStudent();
            CursOptionalStudent f2 = new CursOptionalStudent();
            s1.addCurs(f1, c1.getId(), 60, 9, 0, 0, 40, 10, 0);
            s1.addCurs(f1, c2.getId(), 70, 8, 0, 0, 30, 5, 0);
            s5.addCurs(f1, c5.getId(), 50, 7, 40, 8, 10, 10, 0);
            s5.addCurs(f2, c6.getId(), 0, 0, 0, 0, 0, 0, 10);
            for (Student student : Aplicatie.getStudenti()) {
                student.updateNote();
                System.out.println(student.toString());
                for (CursStudent cursStudent : student.getCursuri()) {
                    fh.write("cursuriStudenti", null, null, null, cursStudent, null, null);
             }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
