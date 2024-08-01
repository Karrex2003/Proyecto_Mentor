package proyects.proyectomentoria.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import proyects.proyectomentoria.entities.CategoriaEntity;

public interface ICategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
