package week4.tic_tak_toe;

import java.util.Random;

public abstract class Strategy {

    private Random generator = new Random();

    abstract Move getMove(ActionFigure figure, ActionFigure[][] boardState);

    protected Move getRandomChoiceMove(Move[] opportunities) {
        Move[] positions = new Move[opportunities.length];
        int position;
        for (int i = 0; i < opportunities.length; ) {
            position = generator.nextInt(opportunities.length);
            if (opportunities[position] != null) {
                positions[i] = opportunities[position];
                if (positions[i].getFigure() == null) {
                    return positions[i];
                }
                opportunities[position] = null;
                i++;
            }
        }
        return null;
    }

}
