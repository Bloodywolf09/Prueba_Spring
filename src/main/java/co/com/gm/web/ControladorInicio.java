package co.com.gm.web;

import co.com.gm.domain.Persona;
import co.com.gm.servicio.PersonaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private PersonaService personaService;
    
    @Operation(summary = "Get all personas", description = "Fetches all personas and returns them along with user information.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Found personas", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Persona.class))),
        @ApiResponse(responseCode = "404", description = "Personas not found", content = @Content)
    })
    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal User user) {
        var personas = personaService.listarPersonas();
        log.info("Ejecutando controlador Spring MVC");
        log.info("usuario que hizo login:" + user);
        model.addAttribute("personas", personas);
        model.addAttribute("totalClientes",personas.size());
        return "index";
    }
    
    @Operation(summary = "Agregar una persona", description = "Agrega una nueva persona.")
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }
    
    @Operation(summary = "Guardar una persona", description = "Guarda una persona validada.")
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        personaService.guardar(persona);
        return "redirect:/";
    }

    @Operation(summary = "Editar una persona", description = "Edita una persona existente.")
    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    @Operation(summary = "Eliminar una persona", description = "Elimina una persona existente.")
    @GetMapping("/eliminar")
    public String eliminar(Persona persona){
        personaService.eliminar(persona);
        return "redirect:/";
    }
}