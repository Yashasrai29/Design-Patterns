package KMP;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class Main {

    public static boolean kmpIntuition(String str, String pattern){
        boolean flag = false;
        int p = 0;
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == pattern.charAt(p)) {
                p++;
            } else {
                while (p > 0) {
                    if (str.charAt(i) == pattern.charAt(p)) {
                        p++;
                        break;
                    } else {
                        p--;
                    }
                }
            }
            if (p == pattern.length()) {
//                p = 0;
//                flag = true;
                return true;
            }
        }
        return flag;
    }
    public static boolean longestSubString(String str, String  pattern){
        List<String> substrings = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            for(int j = i+1; j < str.length(); j++){
                substrings.add(str.substring(i, j));
            }
        }
        for(String each : substrings){
            if(pattern.equals(each)){
                return true;
            }
        }
        return false;
    }

    public List<Integer> search(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        if (pattern == null || pattern.isEmpty()) return occurrences;

        int n = text.length();
        int m = pattern.length();

        // Step 1: Precompute the LPS (Longest Prefix Suffix) array
        int[] lps = computeLPS(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                // Found a match! Store the starting index
                occurrences.add(i - j);
                j = lps[j - 1]; // Move to the next potential match
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1]; // Use LPS to skip unnecessary comparisons
                } else {
                    i++;
                }
            }
        }
        return occurrences;
    }

    private int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0; // length of previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
    public static void main(String[] args) {
        String str = "abxabcabcaby";
        String pattern = "abcaby";
//        System.out.println("Try programiz.pro "+Arrays.toString(lps));
        String bigData = "ABABDABACDABABCABABABABDABACDABABCABAB";
        String pattern2 = "ABABCABAB";
        long start = System.currentTimeMillis();
//        String str = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAT";
        boolean result = longestSubString(str, pattern);
        long end = System.currentTimeMillis();
        System.out.println("Try programiz.pro "+result+ " time taken "+(end-start));
    }
}
