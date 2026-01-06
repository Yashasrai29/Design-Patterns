package leaderboard;

// Online Java Compiler
// Use this editor to write, compile and run your Java code online

import java.util.*;

class Main {

    public static class Player{
        String id;
        Integer score;
        public Player(String id, Integer score){
            this.id = id;
            this.score = score;
        }
    }

    public static class Learderboard {
        Map<String, Player> map;
        PriorityQueue<Player> pq;
        public Learderboard(){
            this.map = new HashMap<>();
            this.pq = new PriorityQueue<>((p1, p2) -> p2.score - p1.score);
        }

        public void addOrUpdatePlayer(String id, Integer score){
            if(!map.containsKey(id)){
                Player player = new Player(id, score);
                map.put(id, player);
                pq.add(player);
            }
            else{
                Player player = map.get(id);
                player.score += score;
            }
        }

        public List<Player> getTopK(int topk){
            List<Player> result = new ArrayList<>();
            while(!pq.isEmpty() && topk > 0){
                result.add(pq.poll());
                topk--;
            }
            return result;
        }
    }

    public static void main(String[] args) {

        Learderboard lb = new Learderboard();
        lb.addOrUpdatePlayer("1", 16);

        lb.addOrUpdatePlayer("sachin", 53);
        lb.addOrUpdatePlayer("2", 4);
        lb.addOrUpdatePlayer("1", 6);
        lb.addOrUpdatePlayer("3", 2);
        lb.addOrUpdatePlayer("4", 5);
        lb.addOrUpdatePlayer("sachin", 50);

        for(Player pair : lb.getTopK(3)){
            System.out.println("vals : " +pair.id+ " score : "+pair.score );
        }


    }
}