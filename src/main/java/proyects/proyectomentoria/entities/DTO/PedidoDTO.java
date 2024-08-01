package proyects.proyectomentoria.entities.DTO;

import java.util.Date;
import java.util.List;
public record PedidoDTO (

    Long id_pedido,
    UsuarioDTO usuarioDTO,
    Date fecha,
    String direccion_envio,
    String estado,
    String metodo_pago,
    Double total,
    List<ProductoDTO> productos
){
}
