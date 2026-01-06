package test;

public class Liskov {

        public static abstract class Bird{
            public abstract void feed();
        }

        public interface Flight{
            void fly();
        }
        public static class Eagle extends Bird implements Flight{

            public Eagle(){}
            @Override
            public void feed(){
                System.out.println("feeding eagle ");
            }

            @Override
            public void fly(){
                System.out.println("eagle flying");
            }
        }

        public static class Pengiun extends Bird{

            public Pengiun(){}

            @Override
            public void feed(){
                System.out.println("feeding Pengiun ");
            }
        }


        public static void main(String[] args) {
            Eagle eagle = new Eagle();
            Pengiun pengiun= new Pengiun();

            eagle.feed();
            eagle.fly();

            pengiun.feed();
        }
}
