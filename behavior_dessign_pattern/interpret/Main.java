package behavior_dessign_pattern.interpret;

public class Main {

    public static void main(String [] args){
        Expression e1 = new TerminalExpression("this is Yashas rai hm");
        Expression e2 = new TerminalExpression("is Bad boy of the world");
//        System.out.println("has name " +e1.interpret("Yashas"));
        Expression and = new AndExpression(e1, e2);
        Expression or = new OrExpression(e1, e2);
        System.out.println("has and " +and.interpret("is"));
        System.out.println("has or " +or.interpret("Yashas"));
    }
}
