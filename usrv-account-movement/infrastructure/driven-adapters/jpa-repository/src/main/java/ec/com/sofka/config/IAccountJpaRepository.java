package ec.com.sofka.config;

import ec.com.sofka.data.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAccountJpaRepository extends JpaRepository<AccountEntity, String> {
    Optional<AccountEntity> findByAccountNumber(String accountNumber);
    Optional<AccountEntity> findByCustomerId(String customerId);
}
