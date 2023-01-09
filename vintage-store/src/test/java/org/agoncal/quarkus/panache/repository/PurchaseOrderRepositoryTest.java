package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.quarkus.jdbc.Artist;
import org.agoncal.quarkus.jpa.Customer;
import org.agoncal.quarkus.jpa.CustomerRepository;
import org.agoncal.quarkus.panache.model.*;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.math.BigDecimal;


@QuarkusTest
public class PurchaseOrderRepositoryTest {

    @Inject
    CustomerRepository customerRepository;


    @Test
    @TestTransaction
    public void shouldCreateAndFindAPurchaseOrder() {
        // Creates an Artist
        Artist artist = new Artist("artist name", "artist bio");
        // Creates a Publisher
        Publisher publisher = new Publisher("publisher name");
        // Creates a Book
        Book book = new Book();
        book.title = "title of the book";
        book.nbOfPages = 500;
        book.language = Language.ENGLISH;
        book.price = new BigDecimal(10);
        book.isbn = "isbn";
        // Sets the relationships
        book.publisher = publisher;
        book.artist = artist;
        // Persists the book
        Book.persist(book);

        // Creates a Customer
        Customer customer = new Customer("Customer first name", "Customer last name", "Customer email");
        customerRepository.persist(customer);

        // Creates an order line
        OrderLine orderLine = new OrderLine();
        orderLine.item = book;
        orderLine.quantity = 2;

        // Creates a Purchase Order
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.customer = customer;
        purchaseOrder.addOrderLine(orderLine);

        PurchaseOrder.persist(purchaseOrder);
    }
}
