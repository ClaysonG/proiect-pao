public class main {
    public static void main(String[] args) {
        aplicatie A = new aplicatie();
        // adaug studenti
        student s1 = new student.student_builder("Popescu", "Stefan", 1).build();
        student s2 = new student.student_builder("Ionescu", "Ioan", 1).build();
        student s3 = new student.student_builder("Pavel", "Ioana", 2).build();
        student s4 = new student.student_builder("Stoica", "Raluca", 2).build();
        student s5 = new student.student_builder("Urziceanu", "Mircea", 4).build();
        A.addStudent(s1);
        A.addStudent(s2);
        A.addStudent(s3);
        A.addStudent(s4);
        A.addStudent(s5);
        for (student student : A.getStudenti()) {
            System.out.println(student.toString());
        }
        // adaug profesori
        profesor p1 = new profesor.profesor_builder("Gherman", "Daniel").build();
        profesor p2 = new profesor.profesor_builder("Drilea", "Sergiu").build();
        profesor p3 = new profesor.profesor_builder("Diaconu", "Antonia").build();
        A.addProfesor(p1);
        A.addProfesor(p2);
        A.addProfesor(p3);
        for (profesor profesor : A.getProfesori()) {
            System.out.println(profesor.toString());
        }
        // adaug cursuri
        curs c1 = new curs.curs_builder("Algebra", p1.getId(), 1).build();
        curs c2 = new curs.curs_builder("Analiza", p1.getId(), 1).build();
        curs c3 = new curs.curs_builder("Programare", p2.getId(), 1).build();
        curs c4 = new curs.curs_builder("Electronica", p2.getId(), 2).build();
        curs c5 = new curs.curs_builder("Teoria Sistemelor", p3.getId(), 2).build();
        curs c6 = new curs.curs_builder("Tehnici Web", p3.getId(), 4).build();
        A.addCurs(c1);
        A.addCurs(c2);
        A.addCurs(c3);
        A.addCurs(c4);
        A.addCurs(c5);
        A.addCurs(c6);
        for (curs curs : A.getCursuri()) {
            System.out.println(curs.toString());
        }
        // afisez profesorii (+ cursurile pe care le predau)
        for (profesor profesor : A.getProfesori()) {
            System.out.println(profesor.toString());
        }
        // adaug note studentilor
        curs_obligatoriu_student f1 = new curs_obligatoriu_student();
        curs_optional_student f2 = new curs_optional_student();
        s1.addCurs(f1, c1.getId(), 60, 9, 0, 0, 40, 10, 0);
        s1.addCurs(f1, c2.getId(), 70, 8, 0, 0, 30, 5, 0);
        s5.addCurs(f1, c5.getId(), 50, 7, 40, 8, 10, 10, 0);
        s5.addCurs(f2, c6.getId(), 0, 0, 0, 0, 0, 0, 10);
        for (student student : A.getStudenti()) {
            student.updateNote();
            System.out.println(student.toString());
        }
    }
}
