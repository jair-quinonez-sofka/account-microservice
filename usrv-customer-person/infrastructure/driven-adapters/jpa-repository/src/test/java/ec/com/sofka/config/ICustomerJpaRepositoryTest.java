package ec.com.sofka.config;


import ec.com.sofka.data.CustomerEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest(classes = TestConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ICustomerJpaRepositoryTest {

    @Autowired
    private ICustomerJpaRepository customerJpaRepository;

    @BeforeEach
    void setUp() {

        customerJpaRepository.deleteAll();


        CustomerEntity customer = new CustomerEntity();
        customer.setIdentification("123456789");
        customer.setName("Juan Pérez");
        customerJpaRepository.save(customer);
    }

    @Test
    void whenFindByIdentification_thenReturnCustomer() {

        CustomerEntity customer = customerJpaRepository.findByIdentification("123456789");


        assertNotNull(customer);
        assertEquals("123456789", customer.getIdentification());
        assertEquals("Juan Pérez", customer.getName());
    }
}


