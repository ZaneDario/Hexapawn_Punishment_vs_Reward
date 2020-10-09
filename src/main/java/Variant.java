import java.util.ArrayList;
import java.util.List;

public class Variant {

    public int depth;
    public boolean xTurn;
    public char[][] board = new char[3][3];
    public List<Piece> pieces = new ArrayList<Piece>();
    private List<Variant> possibleVariants = new ArrayList<Variant>();
    public boolean isFinished = false;

    public Variant(boolean xTurn, int depth)
    {
        this.depth = depth;
        this.xTurn = xTurn;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void posPieces()
    {
        for (Piece piece : pieces ) {
            int xPos = piece.xPos;
            int yPos = piece.yPos;

            board[xPos][yPos] = piece.type;
        }
    }

    public void checkVariants()
    {
        //drawVariant();
        possibleVariants = VariantsCalculator.getPossibleVariant(this);

        if(possibleVariants.size() == 0)
        {
            this.isFinished = true;
            //Game.countVariants(!this.xTurn, "Zugzwang");
        }

        for (Variant variant : possibleVariants) {
            if(!variant.isFinished)
                variant.checkVariants();
        }
    }

    public List<Variant> getPossibleVariants()
    {
        return possibleVariants;
    }


    public void drawVariant()
    {
        System.out.println("---vvv----------- depth: " + this.depth);
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                System.out.print(board[x][y]);
            }
            System.out.println();
        }
    }
}
