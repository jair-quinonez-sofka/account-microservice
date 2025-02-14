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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateCustomerUseCaseTest {
    @Mock
    private ICustomerRepository customerRepository;

    @InjectMocks
    private CreateCustomerUseCase createCustomerUseCase;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Should create a customer when Customer not exists")
    void shouldCreateCustomerWhenNotExists() {

        Customer testCustomer = new Customer(
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
        when(customerRepository.findCustomerByIdentificationNumber("123456789")).thenReturn(null);
        when(customerRepository.save(any(Customer.class))).thenReturn(testCustomer);


        Customer savedCustomer = createCustomerUseCase.apply(testCustomer);


        assertNotNull(savedCustomer);
        assertEquals("John Doe", savedCustomer.getName());
        verify(customerRepository).findCustomerByIdentificationNumber("123456789");
        verify(customerRepository).save(any(Customer.class));
    }

    @Test
    @DisplayName("Should not create a customer when customer exists")
    void shouldThrowExceptionWhenCustomerExists() {

        Customer testCustomer = new Customer(
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
        when(customerRepository.findCustomerByIdentificationNumber("123456789")).thenReturn(testCustomer);


        RuntimeException exception = assertThrows(RuntimeException.class, () -> createCustomerUseCase.apply(testCustomer));
        assertEquals("Customer with identification number 123456789 already exists", exception.getMessage());

        verify(customerRepository).findCustomerByIdentificationNumber("123456789");
        verify(customerRepository, never()).save(any(Customer.class));
    }
}