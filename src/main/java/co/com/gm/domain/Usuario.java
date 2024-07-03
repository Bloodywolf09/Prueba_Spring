package co.com.gm.domain;


import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;


@Entity
@Data
@Table(name="usuario")
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    
    @NotEmpty
    private String username;
    
    @NotEmpty
    private String password;
    
    
    //realacion entre calse de usuario y rol
    @OneToMany
    @JoinColumn(name="id_usuario") //Columna que esta con la FK
    private List<Rol> roles;
    
}