package target;

import target.entities.Book;
import target.entities.User;
import target.enums.Category;
import target.service.BorrowBookService;

import java.util.UUID;

public class Main {

    public static void main(String [] args){
        BorrowBookService service = BorrowBookService.getInstance();
        User user1 = new User("u1", UUID.randomUUID());
        User user2 = new User("u2", UUID.randomUUID());
        User user3 = new User("u3", UUID.randomUUID());
//        Book b1 = service.borrow(user1, Category.ENGLISH);
//        service.borrow(user2, Category.ENGLISH);
//
//        service.returnBook(user1,b1);
//        service.borrow(user2, Category.ENGLISH);
        Thread t1 = new Thread( () -> {
            service.borrow(user1, Category.ENGLISH);
        });
        Thread t2 = new Thread( () -> {
            service.borrow(user2, Category.ENGLISH);

        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }
        catch (Exception e){

        }
    }
}
