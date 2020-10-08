import java.util.ArrayList;
import java.util.List;

public class Game {

    public static int variants = 0;
    public static int xWins = 0;
    public static int oWins = 0;

    public static int simulatedGames = 0;
    public static int oSimulatedWins = 0;

     public void start()
     {
         List<Piece> pieces = new ArrayList<Piece>();

         Piece o1 = new Piece('o', 0, 0);
         Piece o2 = new Piece('o', 1, 0);
         Piece o3 = new Piece('o', 2, 0);
         Piece x1 = new Piece('x', 0, 2);
         Piece x2 = new Piece('x', 1, 2);
         Piece x3 = new Piece('x', 2, 2);

         pieces.add(o1);
         pieces.add(o2);
         pieces.add(o3);
         pieces.add(x1);
         pieces.add(x2);
         pieces.add(x3);

         Board initialBoard = new Board(true, 1);
         initialBoard.pieces = pieces;
         initialBoard.posPieces();

         initialBoard.checkVariants();

         //System.out.println("Variants: " + variants);
         //System.out.println("x wins: " + xWins);
         //System.out.println("o wins: " + oWins);

         for (int i = 0; i < 1000; i++) {
             PunishmentLearning punishmentLearning = new PunishmentLearning();
             punishmentLearning.simulate(initialBoard);
         }


         for (int i = 0; i < 1000; i++) {
             RewardLearning rl = new RewardLearning();
             rl.simulate(initialBoard);
         }

     }

     public static void countVariantsZugz(boolean xTurn)
     {
         Game.variants++;

         if(xTurn)
             Game.xWins++;
         else
             Game.oWins++;

         //System.out.println("----^^^--Variant finished--^^^---- : Zugzwang. x Wins? " + xTurn);
     }

    public static void countVariantsProm(boolean xTurn, int x, int y, char playing)
    {
        Game.variants++;

        if(xTurn)
            Game.xWins++;
        else
            Game.oWins++;

        //System.out.println("----vvvv--Variant finished: Pawn Promoted!! x Wins? " + xTurn);
    }
}
