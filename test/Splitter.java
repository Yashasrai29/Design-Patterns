package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Splitter {

    public static int [] [] split(int [] nums, int k){
        if(k == 0){
            int [] [] empty = new int[1][nums.length];
            empty[0] = nums;
            return empty;
        }
        List<int[]> res = new ArrayList<>();
        int [] arr = new int[k];
        int index = 0, count = 0;
        for(int i = 0; i < nums.length ; i++){
            if (count >= k) {
                res.add(arr);
                arr = new int[k];
                count = 0;
                index = 0;

            }
            arr[index++] = nums[i];
            count++;
        }
        if(count != 0){
            res.add(arr);
        }
        int [] [] ans = new int[res.size()][k];
        for(int i = 0 ; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    public static void main(String [] args){
        int [] nums = {1,2,3,4,5,6,7,8,8,2,2,2,3,3,4,5,9};
        int [] [] res = split(nums, 0);
        for(int [] r : res){
            System.out.println("groups "+ Arrays.toString(r));
        }
    }
}
