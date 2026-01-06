package test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Wellness {

//    52 / 2 -> 26, 26




    public static void shuffle(int [] nums){
        for(int i = 1; i < nums.length-1; i++){
            int destination;
            if(i == nums.length-2){
                swap(nums, i, i+1);
            }
            else {
                destination = ThreadLocalRandom.current().nextInt(i + 1, nums.length - 1);
                swap(nums, i, destination);
            }

        }
    }

    public static void swap(int [] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }


    public static void main(String [] args){
        int [] nums = {1,2,3,4,5,6,7,8};
        shuffle(nums);
        System.out.println("ans "+ Arrays.toString(nums));
    }




//    Microservice   -> Api Gateway(caching, rate limiting, security)->(feed service)* instance  -> feeds_topic -> async worker1 , async worker2 -> worker1 persist in db,
//    worker2 ingest to elastic search aur search and recommendation
//
//    feeds_service distributed lock for having atomicity






}
