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
        Customer customerFound = repository.findCustomerByIdentificationNumber(customer.getIdentification());
        if (customerFound != null) {
            throw new RuntimeException("Customer with identification number " + customer.getIdentification() + " already exists");
        }
        customer.setPassword(PasswordUtils.encryptPassword(customer.getPassword()));
        return repository.save(customer);
    }
}
