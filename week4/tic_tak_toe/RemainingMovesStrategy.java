package week4.tic_tak_toe;

public class RemainingMovesStrategy extends Strategy {

    @Override
    public Move getMove(ActionFigure figure, ActionFigure[][] boardState) {
        Move move;
        if (Move.MIDDLE_CENTER.getFigure() == null) {
            move = Move.MIDDLE_CENTER;
            move.setFigure(figure);
            return move;
        }
        move = getRandomChoiceMove(new Move[]{Move.TOP_LEFT, Move.TOP_RIGHT, Move.BOTTOM_LEFT, Move.BOTTOM_RIGHT});
        if (move != null) {
            move.setFigure(figure);
            return move;
        }
        move = getRandomChoiceMove(new Move[]{Move.TOP_CENTER, Move.MIDDLE_LEFT, Move.MIDDLE_RIGHT, Move.BOTTOM_CENTER});
        if (move != null) {
            move.setFigure(figure);
            return move;
        }
        return null;
    }

}
