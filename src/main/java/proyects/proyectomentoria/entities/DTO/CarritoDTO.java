package proyects.proyectomentoria.entities.DTO;


import java.util.List;

public record CarritoDTO (

    Long id_carrito,
    UsuarioDTO usuarioDTO,
    List<ProductoDTO> productos

)
{}