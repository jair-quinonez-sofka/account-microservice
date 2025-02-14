package ec.com.sofka.adapters;

import ec.com.sofka.config.IMovementJpaRepository;
import ec.com.sofka.gateway.IMovementRepository;
import ec.com.sofka.mapper.MovementEntityMapper;
import ec.com.sofka.movement.Movement;
import org.springframework.stereotype.Repository;

@Repository
public class MovementAdapter implements IMovementRepository {
    private final IMovementJpaRepository movementJpaRepository;

    public MovementAdapter(IMovementJpaRepository movementJpaRepository) {
        this.movementJpaRepository = movementJpaRepository;
    }


    @Override
    public Movement save(Movement movement) {
        return MovementEntityMapper.toMovement(
                movementJpaRepository.save(MovementEntityMapper.toMovementEntity(movement))
        );
    }
}
