package org.agoncal.quarkus.panache.page;

import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import org.agoncal.quarkus.panache.model.Book;
import org.agoncal.quarkus.panache.model.CD;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/page/items")
@Produces(MediaType.TEXT_HTML)
public class ItemPage {

    // Here we are creating the template for Book
    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance book(Book book);
        public static native TemplateInstance books(List<Book> books);
        public static native TemplateInstance cd(CD cd);
        public static native TemplateInstance cds(List<CD> cds);
    }

    @GET
    @Path("/books/{id}")
    public TemplateInstance showBookById(@PathParam("id") Long id) {
        return Templates.book(Book.findById(id));
    }


    @GET
    @Path("/books")
    public TemplateInstance showBookAllBooks() {
        return Templates.books(Book.listAll());
    }

    @GET
    @Path("/cds/{id}")
    public TemplateInstance showCDById(@PathParam("id") long id) {
        return Templates.cd(CD.findById(id));
    }


    @GET
    @Path("/cds")
    public TemplateInstance showCDAllCDs() {
        return Templates.cds(CD.listAll());
    }
}
