package org.agoncal.quarkus.panache.resource;

import io.quarkus.panache.common.Sort;
import org.agoncal.quarkus.jdbc.Artist;
import org.agoncal.quarkus.panache.model.Publisher;
import org.agoncal.quarkus.panache.repository.ArtistRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/api/publishers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PublisherResource {

    // No need to inject any repository because the publisher class is using the Panache entity
//    @Inject
//    PublisherRepository publisherRepository;

    @GET
    @Path("{id}")
    public Publisher findArtistById(@PathParam("id") Long id) {
        return (Publisher) Publisher.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Publisher> findAllPublishers() {
        return Publisher.listAll();
    }

    @GET
    @Path("sorted")
    public List<Publisher> findAllPublishersSorted() {
        return Publisher.listAll(Sort.ascending("name"));
    }


    @GET
    @Transactional
    public Response persistPublisher(Publisher publisher, @Context UriInfo uriInfo) {
        Publisher.persist(publisher);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(publisher.id));
        return Response.created(builder.build()).build();
    }


    @POST
    @Path("{id}")
    @Transactional
    public void deletePublisher(@PathParam("id") Long id) {
        Publisher.deleteById(id);
    }

}
