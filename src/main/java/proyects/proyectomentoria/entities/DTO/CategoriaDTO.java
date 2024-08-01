package proyects.proyectomentoria.entities.DTO;


import java.util.List;

public record CategoriaDTO (

        Long id_categoria,
        String nombre,
        List<ProductoDTO> productos
){
}