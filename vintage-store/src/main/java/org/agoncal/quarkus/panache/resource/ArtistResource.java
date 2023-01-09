package org.agoncal.quarkus.panache.resource;

import org.agoncal.quarkus.jdbc.Artist;
import org.agoncal.quarkus.panache.repository.ArtistRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/api/artists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional(Transactional.TxType.SUPPORTS)
public class ArtistResource {

    @Inject
    ArtistRepository artistRepository;

    @GET
    @Path("{id}")
    public Artist findArtistById(@PathParam("id") Long id) {
        return artistRepository.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Artist> findAllArtists() {
        return artistRepository.listAll();
    }

    @GET
    @Path("sorted")
    @Transactional(Transactional.TxType.REQUIRED)
    public List<Artist> findAllArtistsSorted() {
        return artistRepository.listAllArtistsSorted();
    }

    @GET
    @Transactional
    public Response persistArtist(Artist artist, @Context UriInfo uriInfo) {
        artistRepository.persist(artist);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder().path(Long.toString(artist.getId()));
        return Response.created(builder.build()).build();
    }


    @POST
    @Path("{id}")
    @Transactional
    public void deleteArtist(@PathParam("id") Long id) {
        artistRepository.deleteById(id);
    }

}
