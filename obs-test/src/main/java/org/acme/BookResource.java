package org.acme;

import org.jboss.logging.Logger;

import io.micrometer.core.annotation.Timed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/book")
public class BookResource {
  private static final Logger LOG = Logger.getLogger(BookResource.class);
  
  @Timed(value = "fetch_books")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String fetchBooks() throws InterruptedException {

    LOG.info("Starting to fetch books");
    int random = (int)(Math.random()*10-2) + 2;
    for(int i=0; i<random; i++) {
      fetchBook();
    }
    LOG.info("Found all the fetch books");

    return String.format("I went and fetched you %s different books",random);
  }

  private void fetchBook() throws InterruptedException {
    Thread.sleep(100);
  }
}
