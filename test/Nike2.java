package test;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
// Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

// Input: nums = [-1,0,1,2,-1,-4]

// Output: [[-1,-1,2],[-1,0,1]]

// Input: nums = [0,1,1]

// Output: []

// Input: nums = [0,0,0]

// Output: [[0,0,0]]

import java.util.*;

class Nike2 {

    public static void triplets(List<List<Integer>> result, int index, int [] nums, List<Integer> currentList){
        if(currentList.size() == 3){
            if(currentList.get(0) + currentList.get(1) + currentList.get(2) == 0){
                Collections.sort(currentList);
                result.add(new ArrayList<>(currentList));
            }
        }
        if(index == nums.length){
            return;
        }
        currentList.add(nums[index]);
        triplets(result, index+1, nums, currentList);
        currentList.remove(currentList.size()-1);
        triplets(result, index+1, nums, currentList);
    }
    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> big = new ArrayList<>();
        triplets(big, 0, nums, new ArrayList<>());
        Set<List<Integer>> set = new HashSet<>(big);
        for(List<Integer> li : set){
            System.out.println("ans : "+li.toString());
        }
    }
}