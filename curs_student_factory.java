import com.sun.istack.internal.Nullable;

public abstract class curs_student_factory {
    public abstract curs_student create_curs_student(String id_student, String id_curs,
                                                     @Nullable int procent_examen, @Nullable int nota_examen,
                                                     @Nullable int procent_laborator, @Nullable int nota_laborator,
                                                     @Nullable int procent_seminar, @Nullable int nota_seminar,
                                                     @Nullable int nota_proiect);
}
