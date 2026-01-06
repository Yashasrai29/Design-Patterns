package test;

import java.util.HashMap;
import java.util.Map;

public class KSearch {

    public static boolean search(int [] nums, int k){
        int start = 0, end = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(end != nums.length){
            if(end-start  == k){
                if(map.containsKey(nums[start]) && map.get(nums[start]) >= 1){
                    map.put(nums[start], map.getOrDefault(nums[start], 0) -1);
                }
                start++;
            }
            else{
                map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
                if(map.get(nums[end]) == 2){
                    return true;
                }
                end++;
            }
        }
        return false;
    }
    public static void main(String [] args){
        int [] nums = {1,4,3,2,5,8,2,4,9};
        System.out.println("has duplicate "+search(nums, 5));
    }
}
