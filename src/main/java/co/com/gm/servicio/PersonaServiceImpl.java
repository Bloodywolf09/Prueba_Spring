package co.com.gm.servicio;

import co.com.gm.dao.PersonaDao;
import co.com.gm.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//reconocer como clase de servicio y poder inyectar 
@Service
public class PersonaServiceImpl implements PersonaService{
    
    //inyectar instancia de PersonaDao
    @Autowired
    private PersonaDao personaDao;
    
    @Override
    // va a leer solo la informacion de la BD 
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();        
    }

    @Override
    // en el caso de error hace rollback pero si sale bien, realiza el comit y guardando la info
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    //este metodo tambien solo va a leer información y no la va a modificar
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        //si no encuentra el objeto manda null
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
    
}
