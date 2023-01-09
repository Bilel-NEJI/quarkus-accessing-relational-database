package org.agoncal.quarkus.panache.repository;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.agoncal.quarkus.panache.model.Publisher;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class PublisherRepositoryTest {

    // This test is working fine. We'll comment this and replace it with some default Panache queries just to simplify things
//    @Test
//    @TestTransaction
//    public void shouldCreateAndFindAPublisher() {
//        Publisher publisher = new Publisher("name");
//
//        Publisher.persist(publisher);
//        assertNotNull(publisher.id);
//
//        publisher = Publisher.findById(publisher.id);
//        assertEquals("name", publisher.name);
//
//    }

    @Test
    @TestTransaction
    public void shouldCreateAndFindAPublisher() {
        long count = Publisher.count();
        int listAll = Publisher.listAll().size();
        assertEquals(count, listAll);

        Publisher publisher = new Publisher("name");

        Publisher.persist(publisher);
        assertNotNull(publisher.id);

        assertEquals(count + 1, Publisher.count());

        publisher = Publisher.findById(publisher.id);
        assertEquals("name", publisher.name);

        publisher.deleteById(publisher.id);
        assertEquals(count, publisher.count());
    }


    @Test
    @TestTransaction
    public void shouldCreateAndFindAPublisherWithFindByNamePlusWithContainName() {
        long count = Publisher.count();
        int listAll = Publisher.listAll().size();
        assertEquals(count, listAll);

        Publisher publisher = new Publisher("name");

        Publisher.persist(publisher);
        assertNotNull(publisher.id);

        assertEquals(count + 1, Publisher.count());

        publisher = Publisher.findById(publisher.id);
        publisher = Publisher.findByName(publisher.name).orElseThrow(EntityNotFoundException::new);
        assertEquals("name", publisher.name);

        publisher.deleteById(publisher.id);
        assertEquals(count, publisher.count());
    }


    @Test
    @TestTransaction
    public void shouldCreateAndFindAPublisherWithContainName() {
        long count = Publisher.count();
        int listAll = Publisher.listAll().size();
        assertEquals(count, listAll);

        Publisher publisher = new Publisher("name");

        Publisher.persist(publisher);
        assertNotNull(publisher.id);

        assertEquals(count + 1, Publisher.count());

        publisher = Publisher.findById(publisher.id);
        publisher = Publisher.findByName(publisher.name).orElseThrow(EntityNotFoundException::new);
        assertEquals("name", publisher.name);
        assertTrue(Publisher.findContainName("name").size() >= 1);

        publisher.deleteById(publisher.id);
        assertEquals(count, publisher.count());
    }


}
