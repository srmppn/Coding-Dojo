package boardgame;

import java.util.Scanner;

public class BoardGameApplication {
    private BoardGameImpl boardGame;
    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        BoardGameApplication app = new BoardGameApplication();
        app.boardGame = new BoardGameImpl();
        // init
        System.out.print("Who goes first ? X or O : ");
        boolean competitorTurns = sn.nextLine().toLowerCase().equals("x");
        System.out.println("----------------------------------");
        while(true){
            if(app.boardGame.getTotalTurns() > 9){
                System.out.println("It's a tie");
                break;
            }
            System.out.println((competitorTurns ? "X" : "O") + "'s turn");
            System.out.print("Enter the slot row n column: ");
            int row = sn.nextInt();
            int column = sn.nextInt();
            boolean hasTakeSlot = app.boardGame.TakeSlot(competitorTurns, row, column);
            if(hasTakeSlot){
                competitorTurns = !competitorTurns;
            }
            String winner = app.boardGame.GetWinner();
            if(winner != null){
                System.out.println("The winner's " + winner);
                break;
            }
            System.out.println("----------------------------------");
        }
    }
}