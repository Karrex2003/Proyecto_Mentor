package proyects.proyectomentoria.entities.DTO;

import java.util.Date;

public record ResenaDTO (

    Long id_reseña,
    ProductoDTO producto,
    UsuarioDTO usuarioDTO,
    String comentario,
    Integer puntuacion,
    Date fecha
){}
