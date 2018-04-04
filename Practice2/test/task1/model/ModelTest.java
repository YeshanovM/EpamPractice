package task1.model;

import org.junit.*;
import task1.data.Data;
import task1.entity.Book;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ModelTest {

    private Model model;
    private Book[] books;

    @Before
    public void setUp() {
        books = new Book[4];
        books[0] = new Book("Book1", "Daniel", "Publisher1", 1898, 120, 20000);
        books[1] = new Book("Book 2", "Jack", "Abc", 1988, 1020, 200);
        books[2] = new Book("Book3", "John", "FFFFFF", 2030, 1020, 200);
        books[3] = new Book("Book4", "Jack", "Publisher1", 2008, 1020, 200);
        model = new Model(books.clone());
    }

    @Test
    public void filterByAuthorTest() {
        assertArrayEquals(new Book[] {books[1], books[3]}, model.filterByAuthor("Jack"));
        assertArrayEquals(new Book[] {books[2]}, model.filterByAuthor("John"));
        assertArrayEquals(new Book[] {}, model.filterByAuthor("Not existed author"));
    }

    @Test
    public void filterByPublisherTest() {
        assertArrayEquals(new Book[] {books[0], books[3]}, model.filterByPublisher("Publisher1"));
        assertArrayEquals(new Book[] {books[1]}, model.filterByPublisher("Abc"));
        assertArrayEquals(new Book[] {}, model.filterByPublisher("Not existed publisher"));
    }

    @Test
    public void filterAfterYearTest() {
        assertArrayEquals(new Book[] {books[0], books[1], books[2], books[3]}, model.filterAfterYear(1897));
        assertArrayEquals(new Book[] {books[1], books[2], books[3]}, model.filterAfterYear(1899));
        assertArrayEquals(new Book[] {books[2], books[3]}, model.filterAfterYear(2000));
        assertArrayEquals(new Book[] {}, model.filterAfterYear(2050));
    }

    @Test
    public void sortByPublisherTest() {
        model.sortByPublisher();
        Book[] books = model.getBooks();
        String[] publishers = new String[this.books.length];
        for(int i = 0; i < this.books.length; i++) {
            publishers[i] = this.books[i].getPublisher();
        }
        Arrays.sort(publishers);
        assertEquals(this.books.length, books.length);
        for(int i = 0; i < books.length; i++) {
            assertEquals(publishers[i], books[i].getPublisher());
        }
    }

    @Test
    public void getBooksTest() {
        assertArrayEquals(books, model.getBooks());
    }

    @Test
    public void generateDataTest() {
        model.generateData();
        assertEquals(10, model.getBooks().length);
        for(Book book : model.getBooks()) {
            assertNotNull(book);
            assertNotNull(book.getPublisher());
            assertNotNull(book.getAuthor());
            assertNotNull(book.getName());
            assertTrue(book.getPrice() <= Data.MAX_PRICE);
            assertTrue(book.getPagesCount() <= Data.MAX_PAGES);
            assertTrue(book.getYear() <= LocalDate.now().getYear());
        }
    }
}