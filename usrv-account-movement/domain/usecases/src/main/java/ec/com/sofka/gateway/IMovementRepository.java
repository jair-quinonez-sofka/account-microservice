package ec.com.sofka.gateway;

import ec.com.sofka.movement.Movement;

public interface IMovementRepository {
    Movement save(Movement movement);
}
