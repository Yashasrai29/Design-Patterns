package target.service;

import target.entities.Book;
import target.entities.Library;
import target.entities.User;
import target.enums.Category;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

public class BorrowBookService {

    private Library library;

    private static BorrowBookService instance;

    private BorrowBookService(){
        Book book1 = new Book(UUID.randomUUID(), Category.ENGLISH, "English");
        Book book2 = new Book(UUID.randomUUID(), Category.MATHS, "Maths");
        Book book3 = new Book(UUID.randomUUID(), Category.SCIENCE, "SCIENCE");
        Book book4 = new Book(UUID.randomUUID(), Category.SOCIAL, "SOCIAL");
        library = new Library(Arrays.asList(book1, book2, book4, book3));
    }

    public static BorrowBookService getInstance(){
        if(instance == null){
            synchronized (BorrowBookService.class){
                if(instance == null){
                    instance = new BorrowBookService();
                }
            }
        }
        return instance;
    }


    public synchronized Book borrow(User user, Category category){
        Map<Category, Book> books = library.getBooks();
        if(books.containsKey(category)){
            Book b = books.get(category);
            user.setBook(b);
            books.remove(category);
            return b;
        }
        System.out.println("failed to get books as its not available");
        return null;
//        throw new RuntimeException("Book not available");
    }

    public synchronized String returnBook(User user, Book book){
        Map<Category, Book> books = library.getBooks();
        if(user.getBooks().contains(book)){
            books.put(book.getCategory(), book);
            user.getBooks().remove(book);
        }
        return "Returned Book Successfully";
    }
}
