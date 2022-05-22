import com.sun.istack.internal.Nullable;

public abstract class CursStudentFactory {
    public abstract CursStudent createCursStudent(String idStudent, String idCurs,
                                                  @Nullable int procentExamen, @Nullable int notaExamen,
                                                  @Nullable int procentLaborator, @Nullable int notaLaborator,
                                                  @Nullable int procentSeminar, @Nullable int notaSeminar,
                                                  @Nullable int notaProiect);
}
