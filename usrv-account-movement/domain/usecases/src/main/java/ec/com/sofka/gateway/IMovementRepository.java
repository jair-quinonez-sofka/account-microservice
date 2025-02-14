package ec.com.sofka.gateway;

import ec.com.sofka.movement.Movement;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface IMovementRepository {
    Movement save(Movement movement);
    List<Movement> findMovementsByDateRangeAndCustomer(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("accountNumber") String accountNumber);
}
