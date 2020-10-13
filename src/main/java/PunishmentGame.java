
public class PunishmentGame extends Simulator
{
    @Override
    public void learn(Variant allVariants)
    {
        simulateOneVariant(allVariants);

        if(!xTurn)
        {
            sequence.get(sequence.size()-3).getPossibleVariants().remove(sequence.get(sequence.size()-2));
        }
        else
        {
            Game.oSimulatedWins++;
        }

        Game.checkProgress();
    }

}
