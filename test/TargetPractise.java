package test;

import java.util.*;

public class TargetPractise {

    public static double powerFunc(double x, int n){
        if(n < 0){
            x = 1/ x;
            n = -n;
        }
        double ans = 1;
        while(n > 0) {
            if (n % 2 == 1) {
                ans = ans * x;
                n = n - 1;
            }
            else{
                n = n / 2;
                x = x * x;
            }
        }
        return ans;
    }
    public static Double convertToDecimal(String number){
        double ans = 0;
        boolean deci = false;
        double deciNumber = 0;
        int power = 0;
        for(int i = 0 ; i < number.length(); i++){
            char each = number.charAt(i);
            if(Character.isDigit(each) && !deci){
                ans = (ans * 10) + (each -'0');
            }
            else if(each == '.'){
                deci = true;
            }
            else if(Character.isDigit(each) && deci){
                deciNumber = (deciNumber * 10) + (each - '0');
                power++;
            }
        }
        return ans + (deciNumber / powerFunc(10.0, power));
    }


    public static class Pair{
        int x;
        int y;

        public Pair(int i, int j){
            this.x = i;
            this.y = j;
        }

        @Override
        public boolean equals(Object obj){
            if(this == obj){
               return true;
            }
            if(getClass() != obj.getClass()){
                return false;
            }
            Pair pair = (Pair) obj;
            return this.x == pair.x && this.y == pair.y;
        }

        @Override
        public int hashCode(){
            return Objects.hash(x,y);
        }
    }
    public static List<Pair> duplicates(int[][] nums){
        Set<Pair> visited = new HashSet<>();
        List<Pair> ans = new ArrayList<>();
        for(int [] num : nums){
            if(visited.contains(new Pair(num[0], num[1]))){
                ans.add(new Pair(num[0], num[1]));
            }
            else if(visited.contains(new Pair(num[1], num[0]))){
                ans.add(new Pair(num[1], num[0]));
            }
            else{
                visited.add(new Pair(num[0], num[1]));
            }
        }
        return ans;
    }
    public static void main(String [] args){
        String number = "6256.536";
        System.out.println("ans "+convertToDecimal(number));
        int [] [] nums = {{1,2}, {1, 1}, {2,3}, {3,4}, {5,7}, {2, 1}, {6,1}, {1,1}, {1,2}};
        for(Pair each : duplicates(nums)) {
            System.out.println("duplicates x : " +each.x + " y "+each.y);
        }
    }
}
