package week4.tic_tak_toe;

public class RandomMoveStrategy extends Strategy {

    @Override
    public Move getMove(ActionFigure figure, ActionFigure[][] boardState) {
        Move[] positions = Move.values();
        Move move = getRandomChoiceMove(positions);
        if (move != null) {
            move.setFigure(figure);
            return move;
        }
        return null;
    }

}
