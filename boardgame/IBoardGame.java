package boardgame;

public interface IBoardGame {
    public String GetWinner();
    public boolean TakeSlot(boolean isX,int row, int column);
}