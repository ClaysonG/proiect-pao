import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.ThreadLocalRandom;

public class Aplicatie {
    // private static FileHandler fh = FileHandler.getInstance();
    private static List<Curs> cursuri = new ArrayList<>();
    private static List<Student> studenti = new ArrayList<>();
    private static List<Profesor> profesori = new ArrayList<>();

    private static String url = "jdbc:mysql://localhost:3306/catalog";
    private static String userName = "root";
    private static String password = "Onekey768"; //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Aplicatie() {
    }

    public void addCurs(Curs c) throws IOException, SQLException {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO curs VALUES(" + Integer.parseInt(c.getId()) + ", '" + c.getNume() + "', " + Integer.parseInt(c.getIdProfesor()) + ", " + c.getAn() + ")");
        statement.execute("INSERT INTO audit VALUES(" + ThreadLocalRandom.current().nextInt() + ", 'inserareCurs', '" + new Timestamp(System.currentTimeMillis()) + "')");

        cursuri.add(c);
        // Adaug cursul profesorului care il tine
        for (int i = 0; i < profesori.size(); i++) {
            if (Objects.equals(profesori.get(i).getId(), c.getIdProfesor())) {
                profesori.get(i).addCurs(c);
                break;
            }
        }
        Curs.incrementCursuri();
        // fh.write("cursuri", null, null, c, null, null, null);
        // fh.write("audit", null, null, null, null, "inregistrareCurs", String.valueOf(new Timestamp(System.currentTimeMillis())));
    }

    public void removeCurs(String id) throws SQLException {
        Statement statement = connection.createStatement();
        String idCurs = String.valueOf(id);
        statement.execute("DELETE FROM curs WHERE idCurs=" + idCurs);
        statement.execute("INSERT INTO audit VALUES(" + ThreadLocalRandom.current().nextInt() + ", 'stergereCurs', '" + new Timestamp(System.currentTimeMillis()) + "')");

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

    public void addStudent(Student s) throws IOException, SQLException {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO student VALUES(" + Integer.parseInt(s.getId()) + ", '" + s.getNume() + "', '" + s.getPrenume() + "', " + s.getAn() + ")");
        statement.execute("INSERT INTO audit VALUES(" + ThreadLocalRandom.current().nextInt() + ", 'inserareStudent', '" + new Timestamp(System.currentTimeMillis()) + "')");

        studenti.add(s);
        Student.incrementStudenti();
        // fh.write("studenti", s, null, null, null, null, null);
        // fh.write("audit", null, null, null, null, "inregistrareStudent", String.valueOf(new Timestamp(System.currentTimeMillis())));
    }

    public void removeStudent(String id) throws SQLException {
        Statement statement = connection.createStatement();
        String idStudent = String.valueOf(id);
        statement.execute("DELETE FROM student WHERE idStudent=" + idStudent);
        statement.execute("INSERT INTO audit VALUES(" + ThreadLocalRandom.current().nextInt() + ", 'stergereStudent', '" + new Timestamp(System.currentTimeMillis()) + "')");

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

    public void addProfesor(Profesor p) throws IOException, SQLException {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO profesor VALUES(" + Integer.parseInt(p.getId()) + ", '" + p.getNume() + "', '" + p.getPrenume() + "')");
        statement.execute("INSERT INTO audit VALUES(" + ThreadLocalRandom.current().nextInt() + ", 'inserareProfesor', '" + new Timestamp(System.currentTimeMillis()) + "')");

        profesori.add(p);
        Profesor.incrementProfesori();
        // fh.write("profesori", null, p, null, null, null, null);
        // fh.write("audit", null, null, null, null, "inregistrareProfesor", String.valueOf(new Timestamp(System.currentTimeMillis())));
    }

    public void removeProfesor(String id) throws SQLException {
        Statement statement = connection.createStatement();
        String idProfesor = String.valueOf(id);
        statement.execute("DELETE FROM profesor WHERE idProfesor=" + idProfesor);
        statement.execute("INSERT INTO audit VALUES(" + ThreadLocalRandom.current().nextInt() + ", 'stergereProfesor', '" + new Timestamp(System.currentTimeMillis()) + "')");

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

    public static void listStudenti() throws IOException, SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

        while (resultSet.next()) {
            System.out.println("id: " + resultSet.getInt(1) + " nume: " + resultSet.getString(2)
                    + " prenume: " + resultSet.getString(3) + " an: " + resultSet.getInt(4));
        }

        statement.execute("INSERT INTO audit VALUES(" + ThreadLocalRandom.current().nextInt() + ", 'citireStudenti', '" + new Timestamp(System.currentTimeMillis()) + "')");

        // for (Student student : Aplicatie.getStudenti()) {
        //    System.out.println(student.toString());
        // }
        // fh.write("audit", null, null, null, null, "citireStudenti", String.valueOf(new Timestamp(System.currentTimeMillis())));
    }

    public static void listProfesori() throws IOException, SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM profesor");

        while (resultSet.next()) {
            System.out.println("id: " + resultSet.getInt(1) + " nume: " + resultSet.getString(2)
                    + " prenume: " + resultSet.getString(3));
        }

        statement.execute("INSERT INTO audit VALUES(" + ThreadLocalRandom.current().nextInt() + ", 'citireProfesori', '" + new Timestamp(System.currentTimeMillis()) + "')");

        // for (Profesor profesor : Aplicatie.getProfesori()) {
        //     System.out.println(profesor.toString());
        // }
        // fh.write("audit", null, null, null, null, "citireProfesori", String.valueOf(new Timestamp(System.currentTimeMillis())));
    }

    public static void listCursuri() throws IOException, SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM curs");

        while (resultSet.next()) {
            System.out.println("id curs: " + resultSet.getInt(1) + " nume: " + resultSet.getString(2)
                    + " id profesor: " + resultSet.getInt(3) + " an: " + resultSet.getInt(4));
        }

        statement.execute("INSERT INTO audit VALUES(" + ThreadLocalRandom.current().nextInt() + ", 'citireCursuri', '" + new Timestamp(System.currentTimeMillis()) + "')");

        // for (Curs curs : Aplicatie.getCursuri()) {
        //     System.out.println(curs.toString());
        // }
        // fh.write("audit", null, null, null, null, "citireCursuri", String.valueOf(new Timestamp(System.currentTimeMillis())));
    }

    public static void listStudentiDupaAn(int an) throws IOException, SQLException {
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM student WHERE an =" + an);

        while (resultSet.next()) {
            System.out.println("id: " + resultSet.getInt(1) + " nume: " + resultSet.getString(2)
                    + " prenume: " + resultSet.getString(3) + " an: " + resultSet.getInt(4));
        }

        statement.execute("INSERT INTO audit VALUES(" + ThreadLocalRandom.current().nextInt() + ", 'listareStudentiDupaAn', '" + new Timestamp(System.currentTimeMillis()) + "')");

        // for (Student student : Aplicatie.getStudenti()) {
        //    if (student.getAn() == an) {
        //        System.out.println(student.toString());
        //    }
        // }
        // fh.write("audit", null, null, null, null, "listareStudentiDupaAn", String.valueOf(new Timestamp(System.currentTimeMillis())));
    }

    public static void closeConnection() throws SQLException {
        Aplicatie.connection.close();
    }
}
