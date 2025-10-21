// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.lang.Math;
import java.util.*;

class Main {
    
    public static int kadanes(int [] nums){
        int current = nums[0];
        int max = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            current = Math.max(nums[i], current + nums[i] );
            max = Math.max(max, current);
        }
        return max;
    }

    // [2,3,4] n = 6 - > {}{2}{3}{2,3}{4}{2,4}{3,4}{2,3,4}

    public static List<List<Integer>> powerset(int [] nums){
        List<List<Integer>> ans = new ArrayList<>();
        int n = (int) Math.pow(2, nums.length); //1<<n;
        for(int i = 0 ; i < n ; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0 ; j < nums.length ; j++){
                if((i & (1 << j)) != 0 ){
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
    
    public static void generateSubSet(int index, int [] nums, List<Integer> current, List<List<Integer>> ans){
        if(index == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        generateSubSet(index + 1, nums, current, ans);
        current.remove(current.size() -1);
        generateSubSet(index + 1, nums, current, ans);
    }
    
    public static int lengthOfLIS(List<List<Integer>> ans) {
        int max = 0;
        for(List<Integer> li : ans){
            int count = 1;
            for(int i = 1; i < li.size()  ; i++){
                if(li.get(i) > li.get(i-1) ){
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }
    
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println("max "+kadanes(nums) );
        
        int [] arr = {1,2,3};
        
        System.out.println("ans "+powerset(arr));
        
        int  [] arr2 = {10,9,2,5,3,7,101,18};
        List<List<Integer>> ans = new ArrayList<>();
        generateSubSet(0, arr2, new ArrayList<>(), ans);
        System.out.println("recur ans "+ ans);
        System.out.println("lengthOfLIS "+lengthOfLIS(ans));
    }
}