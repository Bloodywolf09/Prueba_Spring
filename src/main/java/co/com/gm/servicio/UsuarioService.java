package co.com.gm.servicio;

import co.com.gm.dao.UsuarioDao;
import co.com.gm.domain.Rol;
import co.com.gm.domain.Usuario;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Slf4j
public class UsuarioService implements UserDetailsService{ //para poder utilizar la seguridad de Spring

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { // obtener usuario por username
        Usuario usuario = usuarioDao.findByUsername(username); // recuperar el objeto de Usuario
        
        if(usuario == null){
            throw  new UsernameNotFoundException(username);
        }
        
        var roles = new ArrayList<GrantedAuthority>(); //arreglo donde estaran los roles recuperados
        
        for(Rol rol: usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre())); //recuperar los roles
        }
        
        //objeto de Spring
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
    
}
