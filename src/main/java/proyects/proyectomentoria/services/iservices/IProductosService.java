package proyects.proyectomentoria.services.iservices;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import proyects.proyectomentoria.entities.DTO.ProductoDTO;



public interface IProductosService {

    ProductoDTO crearProducto(ProductoDTO productoDTO);

    Page<ProductoDTO> obtener(String nombre, Pageable pageable);

    ProductoDTO actualizarProducto(Long id_Producto, ProductoDTO productoDTO);


    void eliminarProducto (Long id_Producto);

}
