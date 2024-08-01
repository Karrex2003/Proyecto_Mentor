package proyects.proyectomentoria.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Productos")
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_producto;

    @Column(nullable = false)
    String nombre;

    @Column
    String descripcion;

    @Column(nullable = false)
    Double precio;

    @Column(nullable = false)
    Integer stock;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)

    CategoriaEntity categoriaEntity;


    String imagen;

    @OneToMany(mappedBy = "producto")
    List<ResenaEntity> reseñas;

    @ManyToMany(mappedBy = "productos")
    List<CarritoEntity> carritoEntities;

    @ManyToMany(mappedBy = "productos")
    List<PedidoEntity> pedidoEntities;

    public ProductoEntity(String nombre, String descripcion, Double precio, Integer stock, CategoriaEntity categoriaEntity, String imagen) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.categoriaEntity = categoriaEntity;
        this.imagen = imagen;
    }
}