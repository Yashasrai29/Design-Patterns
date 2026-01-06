package test;

public class LongestStringUniqueChar {

    public static int longest(String str){
        int x = 0, y = 0, last = str.length(), max = 0;
        for(int i = 0; i < str.length(); i++){
            while(str.substring(x, y).contains(String.valueOf(str.charAt(i)))){
                x++;
            }
            while(!str.substring(x, y).contains(String.valueOf(str.charAt(i)))){
                y++;
            }
            max = Math.max(max, y-x);
        }
        return max;
    }
    public static void main(String [] args){
        String str = "abcabcbb";
        System.out.println("the longest no repeating chars "+ longest(str));
    }
}
