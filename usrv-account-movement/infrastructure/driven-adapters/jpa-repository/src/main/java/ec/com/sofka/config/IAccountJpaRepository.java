package ec.com.sofka.config;

import ec.com.sofka.data.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountJpaRepository extends JpaRepository<AccountEntity, String> {
}
