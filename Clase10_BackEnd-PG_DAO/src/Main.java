import com.backend.dao.impl.EstudianteDAOH2;
import com.backend.model.Estudiante;
import com.backend.service.EstudianteService;

public class Main {
    public static void main(String[] args) {

        Estudiante estudiante = new Estudiante();

        estudiante.setId(1L);
        estudiante.setNombre("Waltito");
        estudiante.setApellido("Aldana");

        EstudianteService estudianteService = new EstudianteService();
        estudianteService.setEstudianteIDao(new EstudianteDAOH2());

        estudianteService.guardarEstudiante(estudiante);



    }
}