package proyects.proyectomentoria.services.Validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import proyects.proyectomentoria.Exceptions.ProductosExceptions.CategoriaNoExisteException;
import proyects.proyectomentoria.Exceptions.ProductosExceptions.ProductoExistenteException;
import proyects.proyectomentoria.Exceptions.ProductosExceptions.ProductoNoExisteException;
import proyects.proyectomentoria.entities.CategoriaEntity;
import proyects.proyectomentoria.entities.DTO.ProductoDTO;
import proyects.proyectomentoria.entities.ProductoEntity;
import proyects.proyectomentoria.services.repositories.ICategoriaRepository;
import proyects.proyectomentoria.services.repositories.IProductosRepository;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Component
public class ValidatorsProductos {
    @Autowired
    private IProductosRepository productosRepository;
    @Autowired
    private ICategoriaRepository categoriaRepository;

    public void ExcepcionesCrearProducto(ProductoDTO productoDTO, Pageable pageable){
        categoriaNoExiste(productoDTO, pageable);
        productoYaExiste(productoDTO, pageable);
    }

    private void productoYaExiste(ProductoDTO productoDTO, Pageable pageable){
        Optional<ProductoEntity> productos = productosRepository.findByNombre(productoDTO.nombre(), pageable)
                .stream()
                .filter(x -> x.getNombre().describeConstable().isPresent())
                .findFirst();
        if (productos.isPresent()){
            throw new ProductoExistenteException("El producto ya existe");
        }
    }

    private void categoriaNoExiste(ProductoDTO productoDTO, Pageable pageable){
        CategoriaEntity categoriaEntity = categoriaRepository.findById(productoDTO.categoriaId())
                .orElseThrow(() -> new CategoriaNoExisteException("Categoria no encontrada"));
    }
    /*
     * Excepciones para creacion de producto
     */
    public void productoNoExiste(String nombre, Pageable pageable){
        ProductoEntity productos = productosRepository.findByNombre(nombre, pageable)
                .stream()
                .filter(x -> x.getNombre().describeConstable().isPresent())
                .findFirst().orElseThrow(() -> new ProductoNoExisteException("El producto No Existe"));
    }

}
