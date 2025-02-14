package ec.com.sofka.mapper;

import ec.com.sofka.data.MovementDTO;
import ec.com.sofka.movement.Movement;

public class MovementDTOMapper {
    public static MovementDTO ToMovementDTO(Movement movement) {
        return new MovementDTO(
                movement.getDate(),
                movement.getMovementType(),
                movement.getAmount(),
                movement.getBalance()
        );

    }

    public static Movement toMovement(MovementDTO movementDTO) {
        return new Movement(
                null,
                movementDTO.getDate(),
                movementDTO.getMovementType(),
                movementDTO.getAmount(),
                movementDTO.getBalance()
        );
    }
}
