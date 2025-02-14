package ec.com.sofka.mapper;

import ec.com.sofka.data.MovementEntity;
import ec.com.sofka.movement.Movement;

public class MovementEntityMapper {
    public static MovementEntity toMovementEntity(Movement movement) {
        return new MovementEntity(
                movement.getId(),
                movement.getDate(),
                movement.getMovementType(),
                movement.getAmount(),
                movement.getBalance()
        );
    }

    public static Movement toMovement(MovementEntity movementEntity) {
        return new Movement(
                movementEntity.getId(),
                movementEntity.getDate(),
                movementEntity.getMovementType(),
                movementEntity.getAmount(),
                movementEntity.getBalance()
        );
    }
}
