package ec.com.sofka.adapters;

import ec.com.sofka.config.IMovementJpaRepository;
import ec.com.sofka.data.AccountStatementDTO;
import ec.com.sofka.gateway.IMovementRepository;
import ec.com.sofka.mapper.MovementEntityMapper;
import ec.com.sofka.movement.Movement;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Movement> findMovementsByDateRangeAndCustomer(LocalDateTime startDate, LocalDateTime endDate, String accountNumber) {
        return movementJpaRepository.findMovementsByDateRangeAndCustomer(startDate, endDate, accountNumber)
                .stream().map(MovementEntityMapper::toMovement
                ).collect(Collectors.toList());
    }
}
