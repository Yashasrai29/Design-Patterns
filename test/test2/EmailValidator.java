package test.test2;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
public class EmailValidator {


    public static boolean validate(String email){
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9-_.]+$");
    }
    public static void main(String [] args){
        System.out.println("is email "+validate("yashas123@gmail.com"));
        List<String> result = Stream.of("Apple", "Ball", "Cat", "Dog").map(String::toUpperCase).collect(Collectors.toList());
    }
}
