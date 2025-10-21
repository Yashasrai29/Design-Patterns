package sort;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Sort {
    public static void mergeSort(int [] nums, int l, int r){
        if(l < r){
            int mid = l + ((r-l)/2);
            mergeSort(nums, l, mid);
            mergeSort(nums, mid+1, r);
            merge(nums, l , r, mid);
        }
    }
//    2,1,6,9,5,4,3
    public static void merge(int [] nums , int l, int r, int mid){
        int [] temp = new int [ nums.length];
        int i = l , j = mid+1, k = l;
        while(i <= mid && j <= r){
            if(nums[i] < nums[j]){
                temp[k] = nums[i];
                i++;
            }
            else{
                temp[k] = nums[j];
                j++;
            }
            k++;
        }
        while(i <= mid){
            temp[k] = nums[i];
            i++;
            k++;
        }
        while(j <= r){
            temp[k] = nums[j];
            j++;
            k++;
        }
        for(int b = l ; b <= r ; b++){
            nums[b] = temp[b];
        }
    }

    public static void quickSort(int [] nums, int start, int end){
        if(start < end){
            int pivot = quick(nums, start, end);
            quickSort(nums, start, pivot -1);
            quickSort(nums, pivot+1, end);
        }
    }
    public static int quick(int [] nums, int start, int end){
        int pivot = nums[start];
        int i = start;
        for(int p = start +1 ; p <= end ; p++){
            if(nums[p] < pivot){
                i++;
                int temp = nums[p];
                nums[p] = nums[i];
                nums[i] = temp;
            }
        }
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
        return i;
    }

    public static void insertionSort(int [] nums){
        for(int i =1 ; i < nums.length ; i++){
            int temp = nums[i];
            int j = i-1;
            while(j >= 0 && temp < nums[j]){
                nums[j+1] = nums[j];
                j--;
            }
            nums[j+1] = temp;
        }
    }

    public static void selectionSort(int [] nums){
        int i = 0;
        while(i <= nums.length -1){
            int cover = nums[i];
            int coverIndex = i;
            for(int j = i+1 ; j < nums.length ; j++){
                if(nums[j] < cover){
                    cover = nums[j];
                    coverIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[coverIndex];
            nums[coverIndex] = temp;
            i++;
        }
    }

    public static void buildHeap(int [] nums){
        int n = nums.length;
        for(int i = (n/2)-1 ; i >= 0 ; i--){
            heapify(nums, n, i );
        }
    }

    public static void heapify(int [] nums ,int n , int i){
        int l = (i * 2)+1;
        int r= (i * 2) +2 ;
        int largest = i;
        if(l < n && nums[l] > nums[largest]){
            largest = l;
        }
        if( r < n && nums[r] > nums[largest]){
            largest = r;
        }
        if( i != largest){
            int temp = nums[largest];
            nums[largest] = nums[i];
            nums[i] = temp;
            heapify(nums, n , largest);
        }
    }



    public static void main(String[] args) {
        System.out.println("Try programiz.pro");

        int [] nums = {2,1,6,9,5,4,3};
        // int [] nums = {2,1,3};
        // quickSort(nums, 0 , nums.length-1);
        // insertionSort(nums);
        // selectionSort(nums);
        buildHeap(nums);
        // for(int i : nums){
        //     System.out.println("i "+i);
        // }
    }
}