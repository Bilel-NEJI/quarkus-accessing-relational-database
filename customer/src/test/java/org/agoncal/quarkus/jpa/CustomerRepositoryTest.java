package org.agoncal.quarkus.jpa;

import io.quarkus.panache.common.Sort;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class CustomerRepositoryTest {

    @Inject
    CustomerRepository customerRepository;

    @Test
    @TestTransaction
    public void shouldCreateAndFindACustomer() {
        Customer customer = new Customer("first name", "last name", "email");

        customerRepository.persist(customer);
        assertNotNull(customer.getId());

        customer = customerRepository.findById(customer.getId());
        assertEquals("first name", customer.getFirstName());

    }
}
