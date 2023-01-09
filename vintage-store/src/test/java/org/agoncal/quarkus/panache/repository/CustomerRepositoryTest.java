package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.quarkus.jpa.Customer;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

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


    @Test
    @TestTransaction
    public void shouldCreateAndFindACustomerWithDans() {
        assertTrue(customerRepository.listAllDansCustomers().size() <= customerRepository.count());
        Customer customer = new Customer("first name", "last name", "email");

        customerRepository.persist(customer);
        assertNotNull(customer.getId());

        customer = customerRepository.findById(customer.getId());
        assertEquals("first name", customer.getFirstName());

    }
}
