package test;

public class CheckPalindrome {

    public static boolean formPalindrome(String str){
        int [] chars = new int[26];
        for(char c : str.toCharArray()){
            chars[c - 'a']++;
        }
        int count = 0;
        for(int i = 0 ; i < chars.length; i++){
            if(chars[i] % 2 != 0){
                count++;
            }
        }
        if(count > 1){
            return false;
        }
        return true;
    }
    public static void main(String [] args){
        System.out.println("can form palindrome "+formPalindrome("level"));
    }
}
