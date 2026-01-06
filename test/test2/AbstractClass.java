package test.test2;

public class AbstractClass {
    public static abstract class GraphicObject {
        // A concrete method with an implementation
        public void moveTo(int newX, int newY) {
            System.out.println("Moving to X: " + newX + ", Y: " + newY);
        }

        // An abstract method without an implementation
        public abstract void draw();
    }

    // A concrete subclass that must implement the abstract method
    public static class Circle extends GraphicObject {
        public void draw() {
            System.out.println("Drawing a circle");
        }

//        @Override
//        public void moveTo(int newX, int newY) {
//            System.out.println("Moving to X: " + newX + ", Y: " + newY);
//        }
    }

    public static void main(String [] args){
//        Circle circle = new Circle();
//        circle.moveTo(1, 2);
    }
}
