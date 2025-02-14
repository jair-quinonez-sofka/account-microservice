package ec.com.sofka.config;

import ec.com.sofka.customer.Customer;
import ec.com.sofka.data.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerJpaRepository  extends JpaRepository<CustomerEntity, String> {
    CustomerEntity findByIdentification(String identificationNumber);
}
