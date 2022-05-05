import com.sun.istack.internal.Nullable;

public class curs_optional_student extends curs_student_factory {

    @Override // de pus aici atribute pt curs optional
    public curs_student create_curs_student(String id_student, String id_curs, @Nullable int procent_examen, @Nullable int nota_examen,
                                            @Nullable int procent_laborator, @Nullable int nota_laborator,
                                            @Nullable int procent_seminar, @Nullable int nota_seminar,
                                            int nota_proiect) {
        return new curs_optional(id_student, id_curs, nota_proiect);
    }
}
