package ec.com.sofka.usecases;

import ec.com.sofka.customer.Customer;
import ec.com.sofka.gateway.ICustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetCustomerByIdentificationUseCaseTest {

    @Mock
    private ICustomerRepository customerRepository;

    @InjectMocks
    private GetCustomerByIdentificationUseCase getCustomerByIdentificationUseCase;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("Should return a customer when customer exists")
    void shouldReturnCustomerWhenExists() {
        Customer customer = new Customer(
                "John Doe",
                "Male",
                30,
                "123456789",
                "123 Main St",
                "555-1234",
                "CUST001",
                "securePassword",
                true
        );

        when(customerRepository.findCustomerByIdentificationNumber("123456789"))
                .thenReturn(customer);

        Optional<Customer> result = getCustomerByIdentificationUseCase.apply("123456789");

        assertTrue(result.isPresent());
        assertEquals("CUST001", result.get().getCustomerId());
        assertEquals("John Doe", result.get().getName());

        verify(customerRepository).findCustomerByIdentificationNumber("123456789");
    }

    @Test
    @DisplayName("Should return a empty when customer does not exist")
    void shouldReturnEmptyWhenCustomerDoesNotExist() {
        when(customerRepository.findCustomerByIdentificationNumber("000000000"))
                .thenReturn(null);

        Optional<Customer> result = getCustomerByIdentificationUseCase.apply("000000000");

        assertFalse(result.isPresent());

        verify(customerRepository).findCustomerByIdentificationNumber("000000000");
    }
}