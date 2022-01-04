package pieces;

import java.util.ArrayList;
import main.Square;

public interface Piece {
    public ArrayList<Square> move(Square[][] board);
    public void removeFromPane();
    public void addToPane();
    public boolean getIsBlack();
}
