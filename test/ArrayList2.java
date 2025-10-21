package test;

@SuppressWarnings("unchecked")
public class ArrayList2<T>{
    int capacity;
    float growFactor;
    T [] list;
    int count;

    public ArrayList2(int capa, float growFactor){
        this.capacity = capa;
        this.list = (T[]) new Object [capacity];
        this.growFactor = growFactor;
        this.count = 0;
    }

    public void  add(T value){
        if(count == capacity){
            capacity = (int) ((float)capacity * growFactor);
            T [] temp = (T[]) list;
            list = (T[]) new Object [capacity];
            for(int i = 0 ; i < temp.length; i++){
                list[i] = temp[i];
            }
        }
        list[count] = value;
        count++;
    }
//    public T remove(T value){
//
//    }

    public void printAll(){
        for(T each : list){
            System.out.println("each "+each);
        }
    }

    public static class Pair{
        int i;
        int j;
        public Pair(int x, int y){
            this.i = x;
            this.j = y;
        }
    }

    public static void main(String [] args) {
        ArrayList2<Pair> list2 = new ArrayList2<>(5, 1.6F);

        for(int i = 1; i < 20; i++){
//            list2.add(i);
            list2.add(new Pair(i, i+1));
        }

        list2.printAll();

    }
}