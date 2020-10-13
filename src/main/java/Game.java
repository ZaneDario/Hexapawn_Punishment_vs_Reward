import java.util.ArrayList;
import java.util.List;

public class Game {

    public static int variants = 0;
    public static int xWins = 0;
    public static int oWins = 0;

    public static int simulatedGames = 0;
    public static int oSimulatedWins = 0;

    public void start() {

        Variant initialVariant = new Variant(true, 1);
        initialVariant.pieces = initialPieces();
        initialVariant.posPieces();

        initialVariant.checkVariants();

        int gamesCount = 0;
        int tries = 1000;
        for (int i = 0; i < tries; i++) {
            Variant newVariant = initialVariant.copy();
            performSimulation(newVariant);

            gamesCount += simulatedGames;
            simulatedGames = 0;
            oSimulatedWins = 0;
        }
        System.out.println("Average: " + (float)gamesCount/tries + " games to get 98% threshold.");
    }

    public List<Piece> initialPieces()
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

        return pieces;
    }

    public void performSimulation(Variant initialVariant)
    {
        int type = 2; //We can modify this boolean to use either one or other system.
        do {
            Simulator sim = type < 2 ? new RewardGame() : type == 2 ? new PunishmentGame() : new PunishRewardingGame();
            sim.learn(initialVariant);
        }
        while (simulatedGames < 50 || ((float) oSimulatedWins / simulatedGames) < 0.98f);
    }

    public static void countVariants(boolean xTurn, String cause) {
        Game.variants++;

        if (xTurn)
            Game.xWins++;
        else
            Game.oWins++;

        String arrows = cause.equals("Zugzwang") ? "^^^" : "vvv";

        System.out.println("----"+arrows+"--Variant finished--"+arrows+"---- : "+cause+". x Wins? " + xTurn);
    }

    public static void checkProgress()
    {
        Game.simulatedGames++;

        System.out.println("o Wins --> "+ oSimulatedWins + "/" + simulatedGames + " = "
                + ((float) oSimulatedWins/ simulatedGames));

    }
}
