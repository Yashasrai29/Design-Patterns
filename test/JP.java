package test;

public class JP {

//        reduce computation
        public static int compute(int [] nums){
            int i = nums.length-1;
            int count = 0;
            while(i >= 0){
                if(nums[i] % 2 == 1){
                    i--;
                    continue;
                }
                int temp = nums[i];
                if(nums[i] % 2 == 0){
                    nums[i] = temp / 2;
                }

                for(int j = i-1; j >= 0 && i > 1 ; j--){
                    if(nums[j] == temp){
                        nums[j] = temp/2;
                    }
                }

                count++;
            }
            return count;
        }
        public static void main(String[] args) {
            int [] nums = {1, 2, 4 ,5 ,8,9};
            System.out.println("Try programiz.pro "+compute(nums));
        }

}
