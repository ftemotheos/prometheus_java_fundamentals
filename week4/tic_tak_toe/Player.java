package week4.tic_tak_toe;

public class Player {

	private ActionFigure figure;

	public Player(ActionFigure figure) {
        this.figure = figure;
	}

    public ActionFigure getFigure() {
        return figure;
    }

	public Move turn(Board board) {
        ActionFigure[][] boardState = board.getBoardState();
        Strategy strategy;
        Move move = null;
        boolean isStrategyChosen = false;
        switch(TheGame.roundsCounter) {
            case 1:
                strategy = new RandomMoveStrategy();
                move = strategy.getMove(figure, boardState);
                break;
            case 2:
                strategy = new RemainingMovesStrategy();
                move = strategy.getMove(figure, boardState);
                break;
            case 3:
                strategy = new TrickingMoveStrategy();
                move = strategy.getMove(figure, boardState);
                isStrategyChosen = true;
            case 4:
                if (!isStrategyChosen) {
                    strategy = new SavingMoveStrategy();
                    move = strategy.getMove(figure, boardState);
                }
            default:
                if (move == null) {
                    strategy = new FinishingMoveStrategy();
                    move = strategy.getMove(figure, boardState);
                }
                if (move == null) {
                    strategy = new ForkingMoveStrategy();
                    move = strategy.getMove(figure, boardState);
                }
                if (move == null) {
                    strategy = new RemainingMovesStrategy();
                    move = strategy.getMove(figure, boardState);
                }
        }
        return move;
	}

    @Override
    public String toString() {
        return "Player who plays \"" + figure.toString() + "\"";
    }

}
