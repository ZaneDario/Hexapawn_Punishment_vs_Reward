import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Simulator {

    Random random = new Random();
    List<Variant> sequence = new ArrayList<Variant>();
    boolean xTurn = true;

    abstract void learn(Variant completedVariant);

    protected void simulateOneVariant(Variant completeVariant)
    {
        Variant variant = randomVariant(completeVariant);

        while (variant != null)
        {
            xTurn = variant.xTurn;
            variant = randomVariant(variant);
        }
    }

    protected Variant randomVariant(Variant variant)
    {
        int options = variant.getPossibleVariants().size();

        if(options > 0)
        {
            int opt = random.nextInt(options);
            Variant newVariant = variant.getPossibleVariants().get(opt);
            sequence.add(newVariant);
            return newVariant;
        }
        return null;
    }
}
