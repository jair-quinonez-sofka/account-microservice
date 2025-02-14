package ec.com.sofka.adapters;

import ec.com.sofka.config.ICustomerJpaRepository;
import ec.com.sofka.customer.Customer;
import ec.com.sofka.gateway.ICustomerRepository;
import ec.com.sofka.mapper.CustomerEntityMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerAdapter implements ICustomerRepository {
    private final ICustomerJpaRepository customerJpaRepository;


    public CustomerAdapter(ICustomerJpaRepository customerJpaRepository) {
        this.customerJpaRepository = customerJpaRepository;
    }


    @Override
    public Customer findCustomer(String id) {
        return null;
    }

    @Override
    public Customer findCustomerByName(String name) {
        return null;
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return null;
    }

    @Override
    public Customer findCustomerByIdentificationNumber(String identificationNumber) {
        return CustomerEntityMapper.toCustomer(
                customerJpaRepository.findByIdentification(identificationNumber)
        );
    }

    @Override
    public Customer save(Customer customer) {
        return CustomerEntityMapper
                .toCustomer(
                        customerJpaRepository.save(CustomerEntityMapper.toCustomerEntity(customer))
                );
    }
}
