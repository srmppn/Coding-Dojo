package boardgame;

public class BoardGameImpl implements IBoardGame {
    private Boolean[][] boardSlot = new Boolean[3][3];
    // winners are (3,0) (0,3) (3,6) (6,3) (3,3)
    private int[] sumOfX = {0, 0};
    private int[] sumOfO = {0, 0};
    private int xTurnNumber = 1;
    private int oTurnNumber = 1;

    @Override
    public String GetWinner(){
        if(this.xTurnNumber > 3 && this.sumOfX[0] % 3 == 0 && this.sumOfX[1] % 3 == 0){
            return "X";
        }
        else if(this.oTurnNumber > 3 && this.sumOfO[0] % 3 == 0 && this.sumOfO[1] % 3 == 0){
            return "O";
        }
        return null;
    }

    @Override
    public boolean TakeSlot(boolean isX, int row, int column){
        if(this.boardSlot[row][column] == null){
            this.boardSlot[row][column] = isX;
            addValueOfChecker(isX, row, column);
            return true;
        }
        return false;
    }

    public void addValueOfChecker(boolean isX,int row, int column){
        if(isX){
            this.sumOfX[0] += row;
            this.sumOfX[1] += column;
            this.xTurnNumber += 1;
        }
        else{
            this.sumOfO[0] += row;
            this.sumOfO[1] += column;
            this.oTurnNumber += 1;
        }
    }

    public int getTotalTurns() {
        return this.xTurnNumber + this.oTurnNumber;
    }
}