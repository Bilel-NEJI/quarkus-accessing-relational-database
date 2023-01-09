package org.agoncal.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.agoncal.quarkus.jdbc.Artist;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "t_items")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Item extends PanacheEntity {

    @Column(length = 100, nullable = false)
    public String title;
    @Column(length = 3000)
    public String description;
    @Column(nullable = false)
    public BigDecimal price;
    @Column(name = "created_date", nullable = false)
    public Instant createdDate = Instant.now();

    @ManyToOne
    @JoinColumn(name = "artist_fk")
    public Artist artist;
}
