package proyects.proyectomentoria.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "administradores")
public class administradoresEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_administrador;

    @Column(nullable = false)
    String nombre;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String contraseña;
}
