package LLD;

import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Input {



    public static void main(String [] args){
        List<String> statements = new ArrayList<>();
        while(statements.size() != 10){
            try {
                System.out.println("Enter statement to be recorded");
                Scanner scanner = new Scanner(System.in);
                statements.add(scanner.nextLine());
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("statements "+ statements.stream().collect(Collectors.joining(",")).toString());
    }
}
