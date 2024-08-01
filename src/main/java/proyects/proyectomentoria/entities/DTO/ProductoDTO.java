package proyects.proyectomentoria.entities.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;

public record ProductoDTO (
        @JsonIgnore
         Long id_producto,
         String nombre,
         String descripcion,
         Double precio,
         Integer stock,
         Long categoriaId,
         String imagen

) {}