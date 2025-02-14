package ec.com.sofka.gateway;

import ec.com.sofka.customer.Customer;

public interface ICustomerRepository {
    Customer findCustomer(String id);
    Customer findCustomerByName(String name);
    Customer findCustomerByEmail(String email);
    Customer findCustomerByIdentificationNumber(String identificationNumber);
    Customer save(Customer customer);

}
