package target.entities;

import target.enums.Category;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Library {
    private Map<Category, Book> books;


    public Library(List<Book> booksList) {
        this.books = new ConcurrentHashMap<>();
        initialize(booksList);
    }

    public void initialize(List<Book> booksList){
        for(Book book : booksList){
            books.put(book.getCategory(), book);
        }
    }

    public Map<Category, Book> getBooks() {
        return books;
    }

    public void setBooks(Map<Category, Book> books) {
        this.books = books;
    }
}
