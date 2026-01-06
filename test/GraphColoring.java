package test;

import java.util.ArrayList;
import java.util.List;

public class GraphColoring {

    public static int solution(int v, int node, List<List<Integer>> adj, int [] colored, int colors){
        if(node > v){
            return 1;
        }
        int total = 0;
        for(int i = 1 ; i <= colors; i++) {
            if(colored[node] == i){
                continue;
            }
            if(isSafe(adj.get(node), i, colored)) {
//                for(Integer edge : adj.get(node)) {
                    colored[node] = i;
                    total += solution(v, node+1, adj, colored, colors);
                    colored[node] = 0;
//                }
            }
        }
        return total;
    }

    public static boolean isSafe(List<Integer> edges, int color, int[] colored) {
        for (Integer edge : edges) {
            if(colored[edge] == color){
                return false;
            }
        }
        return true;
    }
    public static void main(String [] args){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(1).add(4);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(1);

        String [] colors = {"RED", "GREEN", "BLUE"};
//        boolean [] visited = new boolean[5];
        int [] colored = new int[5];
        int count = solution(4, 1, adj, colored, 3);
        System.out.println("total possibilities : "+count);
    }
}
