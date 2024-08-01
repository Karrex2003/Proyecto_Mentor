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
@Table(name = "Usuarios")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_usuario;

    @Column(nullable = false)
    String nombre;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String contraseña;

    String direccion;

    String telefono;

    @OneToMany(mappedBy = "usuarioEntity")
    List<PedidoEntity> pedidoEntities;

    @OneToOne(mappedBy = "usuarioEntity")
    CarritoEntity carritoEntity;

    @OneToMany(mappedBy = "usuarioEntity")
    List<ResenaEntity> reseñas;
}