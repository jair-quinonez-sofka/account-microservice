package ec.com.sofka.mapper;

import ec.com.sofka.data.MovementDTO;
import ec.com.sofka.data.MovementResponseDTO;
import ec.com.sofka.movement.Movement;

public class MovementDTOMapper {
    public static MovementResponseDTO ToMovementDTO(Movement movement) {
        return new MovementResponseDTO(
                movement.getAccountNumber(),
                movement.getAmount(),
                movement.getBalance(),
                movement.getDate(),
                movement.getMovementType()
        );

    }

    public static Movement toMovement(MovementDTO movementDTO) {
        return new Movement(
                null,
                null,
                null,
                movementDTO.getAmount(),
                null,
                null,
                movementDTO.getAccountNumber()
        );
    }
}
