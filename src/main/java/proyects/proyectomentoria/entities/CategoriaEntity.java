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
@Table(name = "Categorias")

public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_categoria;

    @Column(nullable = false)
    String nombre;

    @OneToMany(mappedBy = "categoriaEntity")
    List<ProductoEntity> productos;

}