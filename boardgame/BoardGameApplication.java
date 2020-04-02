package boardgame;

import java.util.Scanner;

public class BoardGameApplication {
    private IBoardGame boardGame;

    public BoardGameApplication(IBoardGame injectGame){
        this.boardGame =  injectGame;
    }

    public static void main(String[] args){
        Scanner sn = new Scanner(System.in);
        BoardGameApplication app = new BoardGameApplication(new BoardGameImpl());
        // init
        System.out.print("Who goes first ? X or O : ");
        boolean competitorTurns = sn.nextLine().toLowerCase().equals("x");
        System.out.println("----------------------------------");
        while(true){
            System.out.println((competitorTurns ? "X" : "O") + "'s turn");
            System.out.print("Enter the slot row n column: ");
            int row = sn.nextInt();
            int column = sn.nextInt();
            app.boardGame.TakeSlot(competitorTurns, row, column);
            String winner = app.boardGame.GetWinner();
            if(winner != null){
                System.out.println("The winner's " + winner);
                break;
            }
            competitorTurns = !competitorTurns;
            System.out.println("----------------------------------");
        }
    }
}