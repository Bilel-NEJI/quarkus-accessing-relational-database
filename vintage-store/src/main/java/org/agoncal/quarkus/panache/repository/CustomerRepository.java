package org.agoncal.quarkus.panache.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import org.agoncal.quarkus.jpa.Customer;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CustomerRepository implements PanacheRepository<Customer> {

    // This is Simplified Panache Query
    public List<Customer> listAllDansCustomers() {
        return list("firstName = 'Dan'", Sort.by("lastName"));
    }


    // Panache Queries simplifies all this code by invoking the method .list
//    String name = "Dan";
//    List<Customer> customers =
//            getEntityManager()
//                    .createQuery("SELECT c" +
//                            "FROM Customer c" +
//                            "WHEREc.firtName = :pname" +
//                            "ORDER BY c.lastName DESC", Customer.class)
//                    .setParameter("pname", name)
//                    .getResultList();
    //  -----------> becomes like this with Panache Queries
//    String name = "Dan";
//    List<Customer> customers =
//            Customer.list("firstName = ?1", Sort.by("lastName"), name);
}
