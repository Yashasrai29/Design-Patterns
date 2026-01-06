//package test;
//
//public class Wellnessliving {
//
//
//    Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
//
//    Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.
//
//    Example 1:
//
//    Input: s = "abciiidef", k = 3
//    Output: 3
//    Explanation: The substring "iii" contains 3 vowel letters.
//    Example 2:
//
//    Input: s = "aeiou", k = 2
//    Output: 2
//    Explanation: Any substring of length 2 contains 2 vowels.
//
//
//    public class Solution{
//
//        //Input: s = "abciiidef", k = 3
//        start -> 0 -> abc, iii, def
//        start -> 1 -> bci, cii, iii, iid,
//        public static int ans(String s, int k){
//            int max = 0;
//            for(int i = 0; i < s.length(); i++){
//                int start = i, end = i + k;
//                List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
//                while(end < s.length()){
//                    String substring = s.substring(start, end);
//                    int count = 0;
//                    for(char c : substring.tocharArray()){
//                        if(vowels.contains(c)){
//                            count++;
//                        }
//                    }
//                    max = Math.max(max, count);
//                    start += k;
//                    end += k;
//                }
//            }
//            return max;
//        }
//    }
//
//    query
//            content
//
//    {
//        instruction
//    }
//
//    {
//        "role" : "User",
//            "System_prompt" : "Only retrive the relavent Data, discard others",
//            "user_prompt":
//    }
//
//    public class User{
//
//        private int age;
//        private String name;
//        private User(UserBuilder userBuilder){
//            this.age= useBuilder.age;
//            this.name = useBuilder.name;
//        }
//
//    }
//
//    public class UserBuilder{
//
//        private int age;
//        private String name;
//
//        public UserBuilder(){}
//
//        UserBuilder name(){
//            this.name = name;
//            return this;
//        }
//
//        UserBuilder age(){
//            this.age = age;
//            return this;
//        }
//
//        User Build(){
//            return new User(this);
//        }
//
//    }
//
//
//
//
//}
//}
