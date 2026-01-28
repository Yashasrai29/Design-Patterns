package target;


// Online Java Compiler
// Use this editor to write, compile and run your Java code online
// take input from user - usual one
// example -  "firstNonRepeatingChar"; Falafal
// Yashas is giving an interview
import java.util.*;

class OA {
    public static int firstNonRepeatingChar(String word){
        // String word = str.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : word.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        for(int i = 0 ; i < word.length(); i++){
            if(map.containsKey(word.charAt(i)) && map.get(word.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static Character secondHighestFrequency(String word){
        // String word = str.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : word.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) +1);
        }
        map.entrySet().stream().forEach(e -> {
            System.out.println("key "+e.getKey()+ " val "+e.getValue());
            // return e;

        });
        // ).findFirst();
        // .skip(1)
        Optional<Character> optChar = map.entrySet().stream().sorted((e1,e2) -> e2.getValue() - e1.getValue()).map(e -> {
                    // System.out.println("key "+e.getKey()+ " val "+e.getValue());
                    return e.getKey();
                }
        ).findFirst();
        if(optChar.isPresent()){
            return optChar.get();
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println("Enter the input");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        // System.out.println("ans "+firstNonRepeatingChar(input));
        System.out.println("ans "+secondHighestFrequency(input));

        scanner.next();
    }
}
