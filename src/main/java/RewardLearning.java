
public class RewardLearning extends Simulator {

    @Override
    public void learn(Variant allVariants)
    {
        simulateOneVariant(allVariants);

        if(xTurn)
        {
            Game.oSimulatedWins++;
            for (int i = 0; i < sequence.size(); i+=2) {
                Variant duplicatedVariant = sequence.get(i+1);
                sequence.get(i).getPossibleVariants().add(duplicatedVariant);
            }
        }

        Game.checkProgress();
    }
}
