package cl.accenture.proyecto.services;


import cl.accenture.proyecto.model.Persona;
import cl.accenture.proyecto.repositorio.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonaService {

    private PersonaRepository personaRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public void guarPersona(Persona persona){
        personaRepository.save(persona);
    }
    public boolean existePersona(String idPersona){
        return personaRepository.existsById(idPersona);
    }
    public Persona obtenerPersona(String idPersona){
        return personaRepository.findById( idPersona).get();
    }
    public Persona encontrarPersona(String id){
        return personaRepository.findById(id).get();
    }

}
