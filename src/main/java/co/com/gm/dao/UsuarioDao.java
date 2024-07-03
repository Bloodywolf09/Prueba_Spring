package co.com.gm.dao;

import co.com.gm.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {
    
    Usuario findByUsername(String username); //reucperar objeto de tipo usuario filtrado por el username
    
}
