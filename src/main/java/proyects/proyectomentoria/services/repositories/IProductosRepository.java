package proyects.proyectomentoria.services.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proyects.proyectomentoria.entities.DTO.ProductoDTO;
import proyects.proyectomentoria.entities.ProductoEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductosRepository extends JpaRepository<ProductoEntity, Long> {
    Page<ProductoEntity> findByNombre(String nombre, Pageable pageable);

}
