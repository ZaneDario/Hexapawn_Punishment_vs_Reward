import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RewardLearning {

    Random random = new Random();
    List<Board> sequence = new ArrayList<Board>();

    public void simulate(Board completeBoard)
    {
        Board variant = randomVariant(completeBoard);
        boolean xTurn = true;

        while (variant != null)
        {
            xTurn = variant.xTurn;
            variant = randomVariant(variant);
        }

        Game.simulatedGames++;

        if(xTurn)
        {
            Game.oSimulatedWins++;
            for (int i = 0; i < sequence.size(); i+=2) {
                Board duplicatedBoard = sequence.get(i+1);
                sequence.get(i).possibleVariants.add(duplicatedBoard);
            }
        }

        System.out.println("=====================================");
        System.out.println("o Wins --> "+ Game.oSimulatedWins + "/" + Game.simulatedGames + " = "
                + ((float)Game.oSimulatedWins/Game.simulatedGames));

    }

    private Board randomVariant(Board variant)
    {
        int options = variant.possibleVariants.size();

        if(options > 0)
        {
            int opt = random.nextInt(options);
            Board newVariant = variant.possibleVariants.get(opt);
            sequence.add(newVariant);
            return newVariant;
        }
        return null;
    }
}
