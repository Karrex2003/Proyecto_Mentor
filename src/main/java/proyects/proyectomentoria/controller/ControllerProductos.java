package proyects.proyectomentoria.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proyects.proyectomentoria.entities.DTO.ProductoDTO;
import proyects.proyectomentoria.services.iservices.IProductosService;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/Productos")
public class ControllerProductos {

    private final IProductosService productoServicio;

    public ControllerProductos(IProductosService productos) {
        this.productoServicio = productos;
    }


    @PostMapping
    public ResponseEntity<?> crearProducto(@RequestBody ProductoDTO productoDTO) throws URISyntaxException {
        ProductoDTO producto = productoServicio.crearProducto(productoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("se creó el producto");
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Page<ProductoDTO>> obtenerProducto(@PathVariable String nombre, @PageableDefault Pageable pageable){
        Page<ProductoDTO> productos =  productoServicio.obtener(nombre, pageable);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    @PutMapping("/{id_producto}")
    public ResponseEntity<ProductoDTO> actualizarProducto(@PathVariable Long id_producto, @RequestBody ProductoDTO productoDTO) {
        ProductoDTO producto = productoServicio.actualizarProducto(id_producto, productoDTO);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @DeleteMapping("/{id_producto}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id_producto){
        productoServicio.eliminarProducto(id_producto);
        return ResponseEntity.ok("El producto con el id " + id_producto + " fue eliminado");
    }
}
