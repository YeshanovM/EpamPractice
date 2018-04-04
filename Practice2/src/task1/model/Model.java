package task1.model;

import task1.data.*;
import task1.entity.Book;
import java.time.*;
import java.util.*;

public class Model {
    private Book[] books;
    private static final int BOOKS_COUNT = 10;

    public Model() {
        generateData();
    }

    public Model(Book[] books) {
        this.books = books;
    }

    public Book[] filterByAuthor(String author) {
        Book[] result = new Book[books.length];
        int count = 0;
        for(Book book : books) {
            if(book.getAuthor().equals(author)) {
                result[count] = book;
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    public Book[] filterByPublisher(String publisher) {
        Book[] result = new Book[books.length];
        int count = 0;
        for(Book book : books) {
            if(book.getPublisher().equals(publisher)) {
                result[count] = book;
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    public Book[] filterAfterYear(int year) {
        Book[] result = new Book[books.length];
        int count = 0;
        for(Book book : books) {
            if(book.getYear() > year) {
                result[count] = book;
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }

    public void sortByPublisher() {
        Arrays.sort(books, new BookPublisherComparator());
    }

    public void generateData() {
        books = new Book[BOOKS_COUNT];
        for(int i = 0; i < BOOKS_COUNT; i++) {
            String name = Data.NAMES[(int)(Math.random() * Data.NAMES.length)];
            String author = Data.AUTHORS[(int)(Math.random() * Data.AUTHORS.length)];
            String publisher = Data.PUBLISHERS[(int)(Math.random() * Data.PUBLISHERS.length)];
            int year = (int)(Math.random() * LocalDate.now().getYear());
            int pagesCount = (int)(Math.random() * Data.MAX_PAGES);
            int price = (int)(Math.random() * Data.MAX_PRICE);
            books[i] = new Book(name, author, publisher, year, pagesCount, price);
        }
    }

    public Book[] getBooks() {
        return books;
    }
}
