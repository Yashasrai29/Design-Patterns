package test;

import java.util.*;

public class SecretSanta {


    public static void bs(int [] nums, int target){
        int left = 0, right = nums.length-1, min = -1, max = -1;
        while(left <= right){
            int mid = left + ((right - left) / 2);
            if(nums[mid] == target){
                min = max = nums[mid];
                break;
            }
            else if(nums[mid] > target){
                right = mid - 1;
                max = nums[mid];
            }
            else{
                min = nums[mid];
                left = mid + 1;
            }
        }

        System.out.println("min "+min+ " max "+max);
    }
    public static class Pair{
        String from;
        String to;
        public Pair(String f, String t){
            this.from = f;
            this.to = t;
        }
    }
    public static List<Pair> shuffle(String [] names){
        List<Pair> result = new ArrayList<>();
        Random random = new Random();
        String [] temp = new String[names.length];
        System.arraycopy(names, 0, temp, 0, names.length);
        for(int i = 0; i < names.length-1; i++){
            int r = random.nextInt(i+1, names.length);
            // result.add(new Pair(names[i], names[r]));
            swap(temp, i, r);
            // result.add(new Pair(names[i], names[r]));
            // swap(names, i, r);
        }

        for(int i = 0; i < names.length; i++){
            result.add(new Pair(names[i], temp[i]));
        }
        return result;
    }

    public static void swap(String [] names, int start, int end){
        String temp = names[start];
        names[start] = names[end];
        names[end] = temp;
    }
    public static void main(String[] args) {
        int [] nums = {1, 2, 4, 6, 9,15};
        bs(nums, 7);
        String [] names = {"Yashas", "Aruna", "Sridevi", "Sita", "Shravani", "Nibeditha"};
        List<Pair> pairs = shuffle(names);
        for(Pair pair : pairs){
            System.out.println("from "+pair.from+" to "+pair.to);
        }
    }

}
