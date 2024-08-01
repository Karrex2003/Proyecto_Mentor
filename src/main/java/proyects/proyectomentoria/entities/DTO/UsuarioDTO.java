package proyects.proyectomentoria.entities.DTO;


import proyects.proyectomentoria.entities.PedidoEntity;

import java.util.List;

public record UsuarioDTO (

    Long id_usuario,
    String nombre,
    String email,
    String contraseña,
    String direccion,
    String telefono,
    List<PedidoDTO> pedidoDTOS,
    CarritoDTO carritoDTO,
    List<ResenaDTO> reseñas
){}