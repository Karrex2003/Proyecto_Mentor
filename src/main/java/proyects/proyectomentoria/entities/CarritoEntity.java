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
@Table(name = "Carrito")
public class CarritoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_carrito;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    UsuarioEntity usuarioEntity;

    @ManyToMany
    @JoinTable(
            name = "Carrito_Productos",
            joinColumns = @JoinColumn(name = "id_carrito"),
            inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    List<ProductoEntity> productos;


}