import com.sun.istack.internal.Nullable;

public class CursOptionalStudent extends CursStudentFactory {

    @Override // de pus aici atribute pt curs optional
    public CursStudent createCursStudent(String idStudent, String idCurs, @Nullable int procentExamen, @Nullable int notaExamen,
                                         @Nullable int procentLaborator, @Nullable int notaLaborator,
                                         @Nullable int procentSeminar, @Nullable int notaSeminar,
                                         int notaProiect) {
        return new CursOptional(idStudent, idCurs, notaProiect);
    }
}
