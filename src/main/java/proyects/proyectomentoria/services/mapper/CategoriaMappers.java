package proyects.proyectomentoria.services.mapper;

import proyects.proyectomentoria.entities.CategoriaEntity;
import proyects.proyectomentoria.entities.DTO.CategoriaDTO;
import proyects.proyectomentoria.entities.DTO.ProductoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaMappers {
    public static CategoriaDTO categoriaToDTO(CategoriaEntity categoriaEntity) {
        List<ProductoDTO> productosDTO = categoriaEntity.getProductos()
                .stream()
                .map(ProductosMappers::productoToDTO)
                .collect(Collectors.toList());

        return new CategoriaDTO(
                categoriaEntity.getId_categoria(),
                categoriaEntity.getNombre(),
                productosDTO
        );
    }



}

