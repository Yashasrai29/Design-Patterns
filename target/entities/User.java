package target.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User {

    private String name;
    private UUID id;

    private Set<Book> books;

    public User(String name, UUID id ) {
        this.name = name;
        this.id = id;
        this.books = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void setBook(Book book) {
        this.books.add(book);
    }
}
