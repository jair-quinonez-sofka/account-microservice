package ec.com.sofka.handlers;


import ec.com.sofka.data.MovementDTO;
import ec.com.sofka.data.MovementResponseDTO;
import ec.com.sofka.mapper.MovementDTOMapper;
import ec.com.sofka.usecases.movement.CreateMovementUseCase;
import org.springframework.stereotype.Component;

@Component
public class MovementHandler {
    private  final CreateMovementUseCase createMovementUseCase;


    public MovementHandler(CreateMovementUseCase createMovementUseCase) {
        this.createMovementUseCase = createMovementUseCase;
    }

    public MovementResponseDTO createMovement(MovementDTO movementDTO) {
        return MovementDTOMapper.ToMovementDTO(
                createMovementUseCase.apply(
                        MovementDTOMapper.toMovement(movementDTO)
                )
        );
    }
}
