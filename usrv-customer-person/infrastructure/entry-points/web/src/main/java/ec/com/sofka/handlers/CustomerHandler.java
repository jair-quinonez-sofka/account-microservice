package ec.com.sofka.handlers;


import ec.com.sofka.data.CustomerDTO;
import ec.com.sofka.data.CustomerResponseDTO;
import ec.com.sofka.mapper.CustomerDTOMapper;
import ec.com.sofka.usecases.CreateCustomerUseCase;
import org.springframework.stereotype.Component;

@Component
public class CustomerHandler {
    private final CreateCustomerUseCase createCustomerUseCase;


    public CustomerHandler(CreateCustomerUseCase createCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
    }

    public CustomerResponseDTO createCustomer(CustomerDTO customerDTO) {
        return CustomerDTOMapper.toCustomerResponseDTO(createCustomerUseCase.apply(CustomerDTOMapper.toCustomer(customerDTO)));
    }
}
