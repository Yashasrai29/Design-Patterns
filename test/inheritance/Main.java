package test.inheritance;

// Online Java Compiler
// Interface can have same methods

class Main {

    public interface A{

        void print(int a);
    }

    public interface B{

        void print();
    }


    public static class C implements A, B{
        public C(){}

        @Override
        public void print(){
        }
        @Override
        public void print(int a){
        }
    }

    static int test() {

        try {

//            return 1;
            throw new NullPointerException();
        }catch(Exception e){
            e.printStackTrace();
            throw  new RuntimeException("exception");
        }
        finally {

            return 2;

        }

    }

    // Input: s = "abcabcbb"
    public static int substring(String str){
        int max = 0;
        int x = 0, y = 0;
        for(int i = 0; i < str.length(); i++){
            while(str.substring(x, y).contains(String.valueOf(str.charAt(i)))){
                x++;
            }
            while(!str.substring(x, y).contains(String.valueOf(str.charAt(i)))){
                y++;
            }
            max = Math.max(max, y-x);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        C c = new C();
        c.print();
        System.out.println("test " +test());
        int a = 15;
        Integer b = 25;
    }
}
