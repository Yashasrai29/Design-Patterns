package sort;

import java.util.*;

public class TimSort {

        public final static int SIZE = 5;

        public static List<Integer> timSort(int [] nums){
            long startTime = System.currentTimeMillis();
            Queue<List<Integer>> queue = new LinkedList<>();
            List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
            for(int i = 0 ; i < nums.length ; i++){
                if(list.size() == SIZE){
                    queue.offer(new ArrayList<>(list));
                    list.clear();
                    list.add(nums[i]);
                }
                // 1 3 4 5 2
                else{
                    int temp = nums[i];
                    list.add(temp);
                    int size = list.size()-2;
                    while(size >= 0 && list.get(size) > temp){
                        list.set(size+1, list.get(size));
                        size--;
                    }
                    list.set(size+1, temp);
                }
            }
            queue.offer(list);
            while(queue.size() > 1){
                List<Integer> list1 = queue.poll();

                List<Integer> list2 = queue.poll();
                List<Integer> res = new ArrayList<>();
                int l1 = 0, l2 = 0;
                while(l1 != list1.size() && l2 != list2.size()){
                    if(list1.get(l1) < list2.get(l2)){
                        res.add(list1.get(l1));
                        l1++;
                    }
                    else{
                        res.add(list2.get(l2));
                        l2++;
                    }
                }
                while(l1 != list1.size()){
                    res.add(list1.get(l1));
                    l1++;
                }

                while(l2 != list2.size()){
                    res.add(list2.get(l2));
                    l2++;
                }
                queue.offer(res);
            }

            long endTime = System.currentTimeMillis();
            System.out.println("time take tim sort " +(endTime- startTime));
            return queue.poll();
        }



        public static void main(String[] args) {

            int [] nums = { 8,1,4,2,3,6,7,9, 20,21, 22, 99, 23, 24, 28, 26, 15, 28, 35, 25, 30, 31,32,33,34,35, 44, 47, 48, 49, 50};
            int [] nums2 = { 8,1,4,2,3,6,7,9, 20,21, 22, 99, 23, 24, 28, 26, 15, 28, 35, 25, 50, 49, 48, 47, 44, 35,34,33,32,31};
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long startTime = System.currentTimeMillis();
                    Sort.quick(nums2, 0 , nums2.length-1);
                    long endTime = System.currentTimeMillis();
                    System.out.println("time take merge sort " +(endTime- startTime));
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    timSort(nums);
                }
            }).start();

//            System.out.println("ans "+timSort(nums));
        }
}
