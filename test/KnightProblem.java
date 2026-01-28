package test;

import java.util.LinkedList;
import java.util.Queue;

public class KnightProblem {
    public static int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        // Code here
        // int [] [] visited = new int [n+1] [n+1];
        // int [] [] dp = new int[n+1][n+1];
        // for(int i = 0 ; i < dp.length; i++){
        //     Arrays.fill(dp[i], 0);
        // }
        // int res = move(knightPos[0], knightPos[1], knightPos, targetPos, n, visited, dp);
        // return res == Integer.MAX_VALUE ? 0 : res;
        return approach(knightPos, targetPos, n);
    }

    public static class Pair{
        int i;
        int j;
        int dist;
        public Pair(int x, int y, int len){
            this.i = x;
            this.j = y;
            this.dist = len;
        }
    }
    public static int approach(int knightPos[], int targetPos[], int n){
        int [] dx = {-2, -2, 2, 2,-1, 1, -1, 1};
        int [] dy = {-1, 1, -1, 1, -2, -2, 2, 2};
        boolean [] []  visited = new boolean[n+1][n+1];
        Queue<Pair> queue = new LinkedList<>();
        Pair pair = new Pair(knightPos[0], knightPos[1], 0);
        queue.add(pair);
        visited[knightPos[0]] [knightPos[1]] = true;

        while(!queue.isEmpty()){
            Pair curr = queue.poll();
            if(curr.i == targetPos[0] && curr.j == targetPos[1]){
                return curr.dist;
            }
            for(int i = 0 ; i < 8 ; i++){
                int x = curr.i + dx[i];
                int y = curr.j + dy[i];
                if(x > 0  && x <= n && y > 0 && y <= n && !visited[x][y]){
                    visited[x][y] = true;
                    queue.offer(new Pair(x, y, curr.dist + 1));
                }
            }
        }
        return 0;

    }



    public static int move(int i, int j, int [] knightPos, int [] targetPos, int n, int [] [] visited, int [] [] dp){
        if(i <= 0 || i > n || j <= 0 || j > n || visited[i][j] == 1){
            return Integer.MAX_VALUE;
        }
        if(i == targetPos[0] && j == targetPos[1]){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        visited[i][j] = 1;
        // System.out.println("i "+i+ " j "+j);
        int min = Integer.MAX_VALUE;

        int it1 = move(i-2, j-1, knightPos, targetPos, n, visited, dp);
        min = Math.min(min, it1);

        int it2 = move(i-2, j+1, knightPos, targetPos, n, visited, dp);
        min = Math.min(min, it2);

        int id1 = move(i+2, j-1, knightPos, targetPos, n, visited, dp);
        min = Math.min(min, id1);

        int id2 = move(i+2, j+1, knightPos, targetPos, n, visited, dp);
        min = Math.min(min, id2);

        int il1 = move(i-1, j-2, knightPos, targetPos, n, visited, dp);
        min = Math.min(min, il1);

        int il2 = move(i+1, j-2, knightPos, targetPos, n,visited, dp);
        min = Math.min(min, il2);

        int ir1 = move(i-1, j+2, knightPos, targetPos, n, visited, dp);
        min = Math.min(min, ir1);

        int ir2 = move(i+1, j+2, knightPos, targetPos, n, visited, dp);
        min = Math.min(min, ir2);


        visited[i][j] = 0;
        if(min == Integer.MAX_VALUE){
            return dp[i][j] = Integer.MAX_VALUE;
        }
        else{
            return dp[i][j] = 1 + min;
        }
    }

    public static void main(String[] args) {
        int [] startPos = {3,3};
        int [] targetPos = {1,2};
        System.out.println("minimum moves "+minStepToReachTarget(startPos, targetPos, 3));
    }
}
