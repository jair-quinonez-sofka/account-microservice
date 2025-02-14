package ec.com.sofka.usecases;

import ec.com.sofka.customer.Customer;
import ec.com.sofka.gateway.ICustomerRepository;

import java.util.Optional;

public class GetCustomerByIdentificationUseCase {
    private final ICustomerRepository customerRepository;

    public GetCustomerByIdentificationUseCase(ICustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> apply(String identification) {
        return Optional.ofNullable(customerRepository.findCustomerByIdentificationNumber(identification));
    }
}
