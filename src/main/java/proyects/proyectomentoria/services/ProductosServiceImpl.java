package proyects.proyectomentoria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import proyects.proyectomentoria.Exceptions.ProductosExceptions.ProductoNoExisteException;
import proyects.proyectomentoria.entities.CategoriaEntity;
import proyects.proyectomentoria.entities.DTO.ProductoDTO;
import proyects.proyectomentoria.entities.ProductoEntity;
import proyects.proyectomentoria.services.Validators.ValidatorsProductos;
import proyects.proyectomentoria.services.iservices.IProductosService;
import proyects.proyectomentoria.services.mapper.ProductosMappers;
import proyects.proyectomentoria.services.repositories.IProductosRepository;


@Service
public class ProductosServiceImpl implements IProductosService {
    @Autowired
    private IProductosRepository productosRepository;
    @Autowired
    ValidatorsProductos validatorsProductos;

    @Override
    public ProductoDTO crearProducto(ProductoDTO productoDTO) {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        validatorsProductos.ExcepcionesCrearProducto(productoDTO, Pageable.unpaged());
        ProductoEntity producto = ProductosMappers.dtoToProducto(productoDTO, categoriaEntity);
        ProductoEntity save = productosRepository.save(producto);
        return ProductosMappers.productoToDTO(save);
    }

 @Override
    public Page<ProductoDTO> obtener(String nombre, Pageable pageable) {
        validatorsProductos.productoNoExiste(nombre, Pageable.unpaged());
        Page<ProductoEntity> productos = productosRepository.findByNombre(nombre, pageable);
        return productos.map(ProductosMappers::productoToDTO);
    }



    @Override
    public ProductoDTO actualizarProducto(Long id_Producto, ProductoDTO productoDTO) {
        ProductoEntity producto = productosRepository.findById(id_Producto).orElseThrow(() -> new ProductoNoExisteException("El producto no existe"));
        producto.setNombre(productoDTO.nombre());
        producto.setDescripcion(productoDTO.descripcion());
        producto.setPrecio(productoDTO.precio());
        producto.setStock(productoDTO.stock());
        productosRepository.save(producto);
        return ProductosMappers.productoToDTO(producto);
    }

    @Override
    public void eliminarProducto(Long id_Producto) {
        ProductoEntity producto = productosRepository.findById(id_Producto)
                .orElseThrow(() -> new ProductoNoExisteException("El producto no existe"));
            productosRepository.deleteById(id_Producto);
    }
}
