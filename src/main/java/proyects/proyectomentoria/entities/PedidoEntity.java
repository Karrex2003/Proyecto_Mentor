package proyects.proyectomentoria.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pedidos")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_pedido;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    UsuarioEntity usuarioEntity;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    Date fecha;

    @Column(nullable = false)
    String direccion_envio;

    @Column(nullable = false)
    String estado;

    @Column(nullable = false)
    String metodo_pago;

    @Column(nullable = false)
    Double total;

    @ManyToMany
    @JoinTable(
            name = "Pedidos_Productos",
            joinColumns = @JoinColumn(name = "id_pedido"),
            inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    List<ProductoEntity> productos;

}
