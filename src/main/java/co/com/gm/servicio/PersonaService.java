package co.com.gm.servicio;

//posee los metodos que se van a implementar

import co.com.gm.domain.Persona;
import java.util.List;


public interface PersonaService {
    
    //lista de objetos tipo persona
    public List<Persona> listarPersonas();
    
    public void guardar(Persona persona);
    
    public void eliminar(Persona persona);
    
    public Persona encontrarPersona(Persona persona);
    
    
}
