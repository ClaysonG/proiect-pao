import com.sun.istack.internal.Nullable;

public class CursObligatoriuStudent extends CursStudentFactory {

    @Override // de pus aici atribute pt curs obligatoriu
    public CursStudent createCursStudent(String idStudent, String idCurs, int procentExamen, int notaExamen,
                                         int procentLaborator, int notaLaborator,
                                         int procentSeminar, int notaSeminar, @Nullable int notaProiect) {
        return new CursObligatoriu(idStudent, idCurs, procentExamen, notaExamen, procentLaborator, notaLaborator,
                procentSeminar, notaSeminar);
    }
}
