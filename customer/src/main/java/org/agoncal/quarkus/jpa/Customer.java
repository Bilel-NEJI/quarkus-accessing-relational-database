package org.agoncal.quarkus.jpa;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "t_customers")
public class Customer {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "created_date", nullable = false)
    private Instant createdDate = Instant.now();

    public Long getId() {
        return id;
    }

    public Customer setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public Customer setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Customer setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Customer setEmail(String email) {
        this.email = email;
        return this;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public Customer setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, String email, Instant createdDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.createdDate = createdDate;
    }

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
