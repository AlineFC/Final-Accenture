package cl.accenture.proyecto.repositorio;

import cl.accenture.proyecto.model.Persona;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonaRepository extends CrudRepository<Persona, String> {

    List<Persona> findBynombre(String nombre);

    Persona findByemail(String email);
}
