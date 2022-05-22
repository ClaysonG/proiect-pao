import com.sun.istack.internal.Nullable;

import java.io.*;
import java.util.Objects;

public class FileHandler {
    private static FileHandler instance = null;
    private BufferedReader csvReader;
    private FileWriter csvWriter;

    private FileHandler()
    {

    }

    public static FileHandler getInstance()
    {
        if (instance == null)
            instance = new FileHandler();
        return instance;
    }

    public void read(String fileName, Aplicatie aplicatie) throws IOException {
        csvReader = new BufferedReader(new FileReader(fileName + ".csv"));
        String row;
        int rowCount = 0;
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");
            // System.out.println(Arrays.toString(data));
            rowCount++;
            if (rowCount > 1) {
                switch (fileName) {
                    case "studenti": {
                        Student s = new Student.studentBuilder(data[0], data[1], data[2], Integer.parseInt(data[3])).build();
                        aplicatie.addStudent(s);
                        break;
                    }
                    case "profesori": {
                        Profesor p = new Profesor.profesorBuilder(data[0], data[1], data[2]).build();
                        aplicatie.addProfesor(p);
                        break;
                    }
                    case "cursuri": {
                        Curs c = new Curs.cursBuilder(data[0], data[2], data[1], Integer.parseInt(data[3])).build();
                        aplicatie.addCurs(c);
                        break;
                    }
                    case "cursuriStudenti": {
                        String idCurs = data[0];
                        String idStudent = data[1];
                        float nota = Float.parseFloat(data[2]);
                        CursStudent cs = new CursStudent.cursStudentBuilder(idCurs, idStudent, nota).build();
                        for (Student student : Aplicatie.getStudenti()) {
                            if (Objects.equals(student.getId(), idStudent)) {
                                student.addCurs(cs);
                            }
                        }
                        break;
                    }
                }
            }
        }
        csvReader.close();
    }

    public void write(String fileName, @Nullable Student student, @Nullable Profesor profesor, @Nullable Curs curs,
                      @Nullable CursStudent cursStudent, @Nullable String numeActiune,
                      @Nullable String timestamp) throws IOException {
        File csvFile = new File(fileName + ".csv");
        if (!csvFile.exists()) {
            csvWriter = new FileWriter(fileName + ".csv");
            switch (fileName) {
                case "studenti": {
                    csvWriter.append("id");
                    csvWriter.append(",");
                    csvWriter.append("nume");
                    csvWriter.append(",");
                    csvWriter.append("prenume");
                    csvWriter.append(",");
                    csvWriter.append("an");
                    csvWriter.append("\n");
                    break;
                }
                case "profesori": {
                    csvWriter.append("id");
                    csvWriter.append(",");
                    csvWriter.append("nume");
                    csvWriter.append(",");
                    csvWriter.append("prenume");
                    csvWriter.append("\n");
                    break;
                }
                case "cursuri": {
                    csvWriter.append("id");
                    csvWriter.append(",");
                    csvWriter.append("idProfesor");
                    csvWriter.append(",");
                    csvWriter.append("nume");
                    csvWriter.append(",");
                    csvWriter.append("an");
                    csvWriter.append("\n");
                    break;
                }
                case "cursuriStudenti": {
                    csvWriter.append("idCurs");
                    csvWriter.append(",");
                    csvWriter.append("idStudent");
                    csvWriter.append(",");
                    csvWriter.append("nota");
                    csvWriter.append("\n");
                    break;
                }
                case "audit": {
                    csvWriter.append("numeActiune");
                    csvWriter.append(",");
                    csvWriter.append("timestamp");
                    csvWriter.append("\n");
                    break;
                }
            }
        } else {
            csvWriter = new FileWriter(fileName + ".csv", true);
        }

        switch (fileName) {
            case "studenti": {
                csvWriter.append(student.getId());
                csvWriter.append(",");
                csvWriter.append(student.getNume());
                csvWriter.append(",");
                csvWriter.append(student.getPrenume());
                csvWriter.append(",");
                csvWriter.append(String.valueOf(student.getAn()));
                csvWriter.append("\n");
                break;
            }
            case "profesori": {
                csvWriter.append(profesor.getId());
                csvWriter.append(",");
                csvWriter.append(profesor.getNume());
                csvWriter.append(",");
                csvWriter.append(profesor.getPrenume());
                csvWriter.append("\n");
                break;
            }
            case "cursuri": {
                csvWriter.append(curs.getId());
                csvWriter.append(",");
                csvWriter.append(curs.getIdProfesor());
                csvWriter.append(",");
                csvWriter.append(curs.getNume());
                csvWriter.append(",");
                csvWriter.append(String.valueOf(curs.getAn()));
                csvWriter.append("\n");
                break;
            }
            case "cursuriStudenti": {
                csvWriter.append(cursStudent.getIdCurs());
                csvWriter.append(",");
                csvWriter.append(cursStudent.getIdStudent());
                csvWriter.append(",");
                csvWriter.append(String.valueOf(cursStudent.getNota()));
                csvWriter.append("\n");
                break;
            }
            case "audit": {
                csvWriter.append(numeActiune);
                csvWriter.append(",");
                csvWriter.append(timestamp);
                csvWriter.append("\n");
                break;
            }
        }

        csvWriter.flush();
        csvWriter.close();
    }
}
