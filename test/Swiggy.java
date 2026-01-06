package test;

import java.util.*;

public class Swiggy {



/*
Problem Statement:

Given an array meetings where each element is a pair [startDay, endDay] representing a meeting scheduled from startDay to endDay (inclusive), and an integer totalDays, return the number of days without any meetings.

Input:

meetings: List of integer pairs
totalDays: Total number of days in the calendar

Output:

Integer count of days with no meetings scheduled


[[1,5],[2,7],[9,11]] ...-> [[1,7],[9,11]]
12
2

[[1,5],[6,7]]
8
1

[[4,8],[1,3],[2,6]]
 */

    public static class Solution {

        public class Pair implements Comparable<Pair>{
            int start;
            int end;
            public Pair(int start, int end){
                this.start = start;
                this.end = end;
            }

            @Override
            public int compareTo(Pair that){
                return this.start - that.start;
            }
        }

        public int solution(int [] [] nums, int input) {
            List<Pair> pairs = new ArrayList<>();
            for(int [] each : nums){
                pairs.add(new Pair(each[0], each[1]));
            } // O(N)
            Collections.sort(pairs); //O(nlogn) || O(n*n)
            Pair curr = null;
            List<Pair> res = new ArrayList<>();
            for(int i = 0 ; i < pairs.size() ; i++){
                if(curr == null){
                    curr = pairs.get(i);
                }
                else{
                    Pair next = pairs.get(i);
                    if(curr.end >= next.start){
                        curr.end = Math.max(curr.end, next.end);
                    }
                    else{
                        res.add(curr);
                        curr = next;
                    }
                }
            } //O(n)
            if(curr != null){
                res.add(curr);
            }
            int count = 0;
//            for(int i = 1; i <= input ; i++){
//                boolean flag = false;
//                for(int j = 0; j < res.size(); j++){
//                    Pair node = res.get(j);
//                    if(i >= node.start && i <= node.end){
//                        flag = true;
//                        break;
//                    }
//                }
//                if(!flag){
//                    count++;
//                }
//            }
            // O(n * m)  --m is the merged list
//            2nd approach
//            [[1,7],[9,11]]
            int n = 1;
            for(int j = 0; j < res.size(); j++) {
                Pair node = res.get(j);
                int val = node.start-n-1;
                if(val != -1) {
                    count += val;
                }
                n = node.end;
            }
            if(n != input) {
                count += input - n;
            }
            return count;

        }
    }
    public static void main(String[] args) {
//        int [] [] nums = {{1,5},{2,7},{9,11}};
//        int [] [] nums = {{4,8},{1,3},{2,6}};
        int [] [] nums = {{1,3},{6,7},{9,12}};
        Swiggy.Solution sol = new Swiggy.Solution();
        System.out.println("ans "+sol.solution(nums, 12));
    }

}
