package week4.tic_tak_toe;

public class PlayCrossWithComputerCommand implements Command {

    private Player secondPlayer;

    public PlayCrossWithComputerCommand(Player secondPlayer) {
        this.secondPlayer = secondPlayer;
    }

    @Override
    public void execute(Referee referee, Board board) {
        Move move;
        while (true) {
            if ((move = TheGame.humanRound(referee, ActionFigure.CROSS, board)) != null) {
                if (TheGame.roundsCounter > 4 && referee.isWin(move, board)) {
                    break;
                }
            } else {
                break;
            }
            if ((move = TheGame.computerRound(referee, secondPlayer, board)) != null) {
                if (TheGame.roundsCounter > 4 && referee.isWin(move, board)) {
                    break;
                }
            } else {
                break;
            }
        }
        referee.printWinner(move, secondPlayer);
    }

}
