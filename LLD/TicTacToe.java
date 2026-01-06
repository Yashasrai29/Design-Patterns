package LLD;

import javax.sound.midi.SysexMessage;

public class TicTacToe {

    public static class Cell{
        public  Cell(){}
    }

    public static class CellX extends Cell{
        public CellX(){

        }
    }

    public static class CellO extends Cell{
        public CellO(){

        }
    }

    public static class Player{
        private String name;

        private Cell cellType;
        public Player(String name, Cell cellType){
            this.name = name;
            this.cellType = cellType;
        }
    }

    public static class Turn{
        private Context context;
        public Turn(Context context){
            this.context = context;
        }
        public boolean isValid(Player player){
            if(player.cellType == context.cellType){
                return true;
            }
            return false;
        }
    }

    public static class Context{


        private Cell cellType;


        public Context(Cell cellType){
            this.cellType = cellType;
        }
        public void setState(){
            if(cellType instanceof CellX){
                cellType = new CellO();
            }
            else{
                cellType = new CellX();
            }
        }

    }

    private static Player [] [] board;

    private static int count;

    private static Context context;

    private static boolean won;
    public TicTacToe(Context context){
        this.board = new Player[3][3];
        this.count = 0;
        this.context = context;
        this.won = false;
    }

    public boolean play(int i, int j, Player player){
        try {
            if(won){
                throw new RuntimeException("Match has already finished");
            }
            if (player.cellType.getClass() != context.cellType.getClass()) {
                throw new RuntimeException("Unauthorized Move");
            }
            if (board[i][j] != null) {
                throw new RuntimeException("can not fill");
            }
            board[i][j] = player;
            count++;
            if (check(board, i, j, player)) {
                won = true;
                System.out.println("Victory to player " + player.name);
                return true;
            }
            if (count == 9) {
                System.out.println("Draw");
            }
            return false;
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            context.setState();
        }
        return false;
    }

    public boolean check(Player[][] board, int i, int j, Player player){
        for(int r = 0; r < 3 ; r++){
            int count = 0;
            for(int c = 0; c < 3 ; c++){
                if(board[r][c] != null && board[r][c].cellType == player.cellType){
                    count++;
                }
            }
            if(count == 3){
                return true;
            }
        }
        for(int c = 0; c < 3 ; c++){
            int count = 0;
            for(int r = 0; r < 3 ; r++){
                if(board[r][c] != null && board[r][c].cellType == player.cellType){
                    count++;
                }
            }
            if(count == 3){
                return true;
            }
        }
        int count2 = 0;
        for(int r = 2, c = 0; r >= 0 && c < 3; r--, c++){
            if(board[r][c] != null && board[r][c].cellType == player.cellType){
                count2++;
            }
        }
        if(count2 == 3){
            return true;
        }

        int count3 = 0;
        for(int r = 0, c = 0; r < 3 && c < 3; r++, c++){
            if(board[r][c] != null && board[r][c].cellType == player.cellType){
                count3++;
            }
        }

        if(count3 == 3){
            return true;
        }
        return false;
    }

    public static void main(String [] args){
        Context context1 = new Context(new CellX());
        TicTacToe ticTacToe = new TicTacToe(context1);
        Player player1 = new Player("Yashas", new CellX());
        Player player2 = new Player("Saleem", new CellO());
        ticTacToe.play(0,0, player1);
        ticTacToe.play(0,1, player2);
        ticTacToe.play(2,0, player1);
        ticTacToe.play(2, 2, player2);
        ticTacToe.play(1,0, player1);
        ticTacToe.play(2, 1, player2);


    }
}
