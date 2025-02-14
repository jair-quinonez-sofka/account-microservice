package ec.com.sofka.config;

import ec.com.sofka.data.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovementJpaRepository extends JpaRepository<MovementEntity, String> {
}
