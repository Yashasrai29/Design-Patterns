package test;

import java.util.*;
public class substring {

    // Online Java Compiler
// Use this editor to write, compile and run your Java code online

       //Input: s = "abciiidef", k = 3
//   	start -> 0 -> abc, iii, def
//     start -> 1 -> bci, cii, iii, iid,
        public static int ans(String s, int k){
            int max = 0;
            for(int i = 0; i < s.length(); i++){
                int start = i, end = i + k;
                List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
                while(end < s.length()){
                    String substring = s.substring(start, end);
                    int count = 0;
                    for(char c : s.substring(start, end).toCharArray()){
                        if(vowels.contains(c)){
                            count++;
                        }
                    }
                    max = Math.max(max, count);
                    start += k;
                    end += k;
                }
            }
            return max;
        }

        public static int twopointer(String s, int k){
            // s = "abciiidef", k = 3
            int count = 0, max = 0;
            List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
            int start = 0, end = 0, total = 0;
            while(end < s.length()){
                // if(vowels.contains(s.charAt(end)){
                //     count++;
                // }
                if(total == k){
                    if(vowels.contains(s.charAt(start))){
                        count--;
                    }
                    start++;
                    total--;
                }
                else{
                    if(vowels.contains(s.charAt(end))){
                        count++;
                    }
                    total++;
                    end++;
                }
                max = Math.max(max, count);

            }
            return max;
        }


        public static void main(String[] args) {

            System.out.println("ans "+twopointer("abciiidef", 3));
        }

}
