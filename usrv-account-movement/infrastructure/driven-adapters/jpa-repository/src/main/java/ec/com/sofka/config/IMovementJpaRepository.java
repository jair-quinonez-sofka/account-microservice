package ec.com.sofka.config;

import ec.com.sofka.data.MovementEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface IMovementJpaRepository extends JpaRepository<MovementEntity, String> {
    @Query("SELECT m FROM MovementEntity m WHERE m.date BETWEEN :startDate AND :endDate " +
            "AND m.accountNumber = :accountNumber " +
            "ORDER BY m.date DESC")
    List<MovementEntity> findMovementsByDateRangeAndCustomer(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("accountNumber") String accountNumber);
}
