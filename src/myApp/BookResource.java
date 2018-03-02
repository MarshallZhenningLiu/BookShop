package myApp;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;



@Path("/books")
public class BookResource {
	
	private final static Logger LOG = Logger.getLogger(BookResource.class.getName());
	
	// This method is called if XMLis request
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON,
			MediaType.TEXT_XML })
	public List<Book> getBooks() {
		LOG.info("-----------------getBooks line 32: ");
		return BookDao.instance.getBooks();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON,
			MediaType.TEXT_XML })
	@Path("{bookName}")
	public Book getBook(@PathParam("bookName") String bookName) {
		LOG.info("-----------------getBook line 40: " + bookName);
		return BookDao.instance.getBook(bookName);
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void postBook(@FormParam("bookName") String bookName,
			@FormParam("bookAuthor") String bookAuthor,
			@FormParam("bookPrice") String bookPrice,
			@Context HttpServletResponse servletResponse) throws IOException {
		
		LOG.info("-----------------postBook line 51: " + bookName);

		Book book = new Book();
		book.setBookAuthor("bookName");
		book.setBookAuthor("bookAuthor");
		book.setBookPrice(Double.parseDouble(bookPrice));
		
		BookDao.instance.create(book);
		servletResponse.sendRedirect("../register.html");
	}

	@DELETE
	@Produces(MediaType.TEXT_HTML)
	@Path("{bookName}")
	public void deleteBook(@PathParam("bookName") String bookName) throws IOException {
		LOG.info("-------------deleteBook line 66: " + bookName);

		BookDao.instance.delete(bookName);
	}

	@PUT
	@Produces(MediaType.TEXT_HTML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Path("{bookName}")
	public void putBook(@PathParam("bookName") String bookName,
			@FormParam("bookAuthor") String bookAuthor,
			@FormParam("bookPrice") String bookPrice,
			@Context HttpServletResponse servletResponse) throws IOException {
	
		LOG.info("----------------putBook line 80: " + bookName);
		Book book = new Book();
		book.setBookAuthor("bookName");
		book.setBookAuthor("bookAuthor");
		book.setBookPrice(Double.parseDouble(bookPrice));
		
		BookDao.instance.create(book);
	}
}