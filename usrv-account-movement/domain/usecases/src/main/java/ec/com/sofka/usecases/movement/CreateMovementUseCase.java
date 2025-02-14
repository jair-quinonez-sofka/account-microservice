package ec.com.sofka.usecases.movement;

import ec.com.sofka.gateway.IBusMessage;
import ec.com.sofka.gateway.IMovementRepository;
import ec.com.sofka.movement.Movement;

public class CreateMovementUseCase {
    private final IMovementRepository movementRepository;
    private final IBusMessage busMessage;

    public CreateMovementUseCase(IMovementRepository movementRepository, IBusMessage busMessage) {
        this.movementRepository = movementRepository;
        this.busMessage = busMessage;
    }

    public Movement apply(Movement movement) {
        String response  = busMessage.sendMessage("Customer created");
        System.out.println("response  "+response);
        if(response == null) {
            throw new RuntimeException("Customer creation failed");
        }
        return movementRepository.save(movement);
    }
}
