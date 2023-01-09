package org.agoncal.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "t_publishers")
public class Publisher extends PanacheEntity {

    // the attributes are public; not private
    // no getters and no setters
    // we will not create a repository class since the "Publisher" class extends "PanacheEntity" which itself extends "PanacheRepository"

    @Column(length = 50, nullable = false)
    public String name;
    @Column(name = "created_date", nullable = false)
    public Instant createdDate = Instant.now();

    public Publisher() {
    }

    public Publisher(String name) {
        this.name = name;
    }



    // For the "Publisher" case, we are defining the Panache Query here because, we already don't have a PublisherRepository with Panache (like we did use the entity "exp.:Publisher.id" instead of entity manager. So it is a short-cut given by Panache to exploit the Panache Queries.
    // Of course, if we don't like this pattern, even for Panache we can use (repositories) the jpql
    public static Optional<Publisher> findByName(String name) {
        return Publisher.find("name", name).firstResultOptional();
    }

    public static List<Publisher> findContainName(String name) {
        return Publisher.list("name like ?1", "%" + name + "%");
    }
}
