package proyects.proyectomentoria.services.mapper;


import proyects.proyectomentoria.entities.CategoriaEntity;
import proyects.proyectomentoria.entities.DTO.ProductoDTO;
import proyects.proyectomentoria.entities.ProductoEntity;

public class ProductosMappers {

    private ProductosMappers() throws IllegalAccessException {
        throw new IllegalAccessException("Util class");
    }

    public static ProductoDTO productoToDTO(ProductoEntity productoEntity) {
        return new ProductoDTO(
                productoEntity.getId_producto(),
                productoEntity.getNombre(),
                productoEntity.getDescripcion(),
                productoEntity.getPrecio(),
                productoEntity.getStock(),
                productoEntity.getCategoriaEntity().getId_categoria(),
                productoEntity.getImagen()
        );


    }
    public static ProductoEntity dtoToProducto(ProductoDTO productoDTO, CategoriaEntity categoriaEntity) {
        return new ProductoEntity(
                productoDTO.nombre(),
                productoDTO.descripcion(),
                productoDTO.precio(),
                productoDTO.stock(),
                categoriaEntity,
                productoDTO.imagen()
        );
    }
}

