package LLD;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SnakeAndFood {

    private static int [] [] grid;

    private static int x;
    private static int y;
    private static int n;

    private static int refill;

    private final static int APPLE_PRICE = 5;

    private static int score;

    public static boolean end = false;

    public static PriorityQueue<Integer> highestScores;
    public SnakeAndFood(int n, int foodFillPercent){
        this.grid = new int[n+1][n+1];
        Random r = new Random();
        r.nextInt(25, 50);
        this.x = ThreadLocalRandom.current().nextInt(0, n);
        this.y = ThreadLocalRandom.current().nextInt(0, n);
        this.n = n;
        this.refill = 0;
        this.score = 0;
        this.highestScores = new PriorityQueue<>();
        fillFood(n, foodFillPercent);
    }

    public static void fillFood(int n, double foodFillPercent){
        int count = (int)((n*n) * (foodFillPercent / 100));
        while(count > 0){
            int i = ThreadLocalRandom.current().nextInt(0, n);
            int j = ThreadLocalRandom.current().nextInt(0, n);
            if(grid[i][j] == 0){
                grid[i][j] = 1;
                count--;
            }
        }
    }

    public static void topper(){
        while(highestScores.size() > 3){
            highestScores.poll();
        }
    }

    public static void refillStrategy(){
        double dn = ThreadLocalRandom.current().nextInt(n, n + n);
        int count = (int)((n*n) * (dn / 100));
        while(count > 0){
            int i = ThreadLocalRandom.current().nextInt(0, n);
            int j = ThreadLocalRandom.current().nextInt(0, n);
            if(grid[i][j] == 0){
                grid[i][j] = 1;
                count--;
            }
        }
        refill = 0;
    }

    public static void play(String cmd){
        try {
            int i = x;
            int j = y;
            switch (cmd) {
                case "LEFT" -> {
                    j--;
                    if (j < 0) {
                        end = true;
                        highestScores.add(score);
                        throw new RuntimeException("OUT with score : " + score);
                    }
                }
                case "RIGHT" -> {
                    j++;
                    if (j > n) {
                        end = true;
                        highestScores.add(score);
                        throw new RuntimeException("OUT with score : " + score);
                    }
                }
                case "TOP" -> {
                    i--;
                    if (i < 0) {
                        end = true;
                        highestScores.add(score);
                        throw new RuntimeException("OUT with score : " + score);
                    }
                }
                case "DOWN" -> {
                    i++;
                    if (i > n) {
                        end = true;
                        highestScores.add(score);
                        throw new RuntimeException("OUT with score : " + score);
                    }
                }
                default -> {
                    return;
                }
            }
            score++;
            refill++;
            if (grid[i][j] == 1) {
                score += APPLE_PRICE;
                grid[i][j] = 0;
                refill += APPLE_PRICE;
            }
            x = i;
            y = j;
        } catch (Exception e){
            e.printStackTrace();
        }
        finally{
            topper();
            if(refill >= n+n){
                refillStrategy();
            }
        }
    }


    public static void main(String [] args){
        SnakeAndFood snakeAndFood = new SnakeAndFood(6, 35);
        while(!snakeAndFood.end){
            System.out.println("Enter the option \n LEFT to move left \n RIGHT to move right \n TOP to move top \n DOWN to move down \n");
            Scanner scanner = new Scanner(System.in);
            snakeAndFood.play(scanner.nextLine());
        }
    }
}
