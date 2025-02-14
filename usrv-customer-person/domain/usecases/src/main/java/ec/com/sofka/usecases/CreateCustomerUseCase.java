package ec.com.sofka.usecases;

import ec.com.sofka.PasswordUtils;
import ec.com.sofka.customer.Customer;
import ec.com.sofka.gateway.ICustomerRepository;


public class CreateCustomerUseCase {
    private final ICustomerRepository repository;


    public CreateCustomerUseCase(ICustomerRepository repository) {
        this.repository = repository;
    }

    public Customer apply(Customer customer) {
        customer.setPassword(PasswordUtils.encryptPassword(customer.getPassword()));
        return repository.save(customer);
    }
}
