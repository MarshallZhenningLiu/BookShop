package myApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;


public enum BookDao {
  instance;

  private final static Logger LOG = Logger.getLogger(BookDao.class.getName());
  private Map<String, Book> booksMap = new HashMap<String, Book>();

  private BookDao() {

    Book book1 = new Book();
    book1.setBookName("book1");
    book1.setBookAuthor("author1");
    book1.setBookPrice(10.00);
    
    booksMap.put("book1", book1);

    Book book2 = new Book();
    book1.setBookName("book2");
    book1.setBookAuthor("author2");
    book1.setBookPrice(20.00);

    booksMap.put("book2", book2);
  }

  public List<Book> getBooks() {
	LOG.info("--------getBooks line34: ");
    List<Book> books = new ArrayList<Book>();    
    return books;
  }

  public Book getBook(String bookName) {
	  LOG.info("--------getBook line40: "+ bookName);
    return booksMap.get(bookName);
  }

  public void create(Book book) {
	  LOG.info("--------create line45: " + book.getBookName());
    booksMap.put(book.getBookName(), book);
  }

  public void delete(String bookName) {
	  LOG.info("--------delete line50: " + bookName);
    if (booksMap.remove(bookName) != null) {
      System.out.println("Removed");
    } else {
      System.out.println("Not Removed");
    }
  }

}
