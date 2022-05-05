import com.sun.istack.internal.Nullable;

public class curs_obligatoriu_student extends curs_student_factory {

    @Override // de pus aici atribute pt curs obligatoriu
    public curs_student create_curs_student(String id_student, String id_curs, int procent_examen, int nota_examen,
                                            int procent_laborator, int nota_laborator,
                                            int procent_seminar, int nota_seminar, @Nullable int nota_proiect) {
        return new curs_obligatoriu(id_student, id_curs, procent_examen, nota_examen, procent_laborator, nota_laborator,
                procent_seminar, nota_seminar);
    }
}
