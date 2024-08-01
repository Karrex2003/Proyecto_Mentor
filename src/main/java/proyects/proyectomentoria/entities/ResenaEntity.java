package proyects.proyectomentoria.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Reseñas")
public class ResenaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_reseña;
    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    ProductoEntity producto;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    UsuarioEntity usuarioEntity;
    @Column
    String comentario;
    @Column(nullable = false)
    Integer puntuacion;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date fecha;
}