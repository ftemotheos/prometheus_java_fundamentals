package week4.tic_tak_toe;

public class PlayNoughtWithComputerCommand implements Command {

    private Player firstPlayer;

    public PlayNoughtWithComputerCommand(Player firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    @Override
    public void execute(Referee referee, Board board) {
        Move move;
        while (true) {
            if ((move = TheGame.computerRound(referee, firstPlayer, board)) != null) {
                if (TheGame.roundsCounter > 4 && referee.isWin(move, board)) {
                    break;
                }
            } else {
                break;
            }
            if ((move = TheGame.humanRound(referee, ActionFigure.NOUGHT, board)) != null) {
                if (TheGame.roundsCounter > 4 && referee.isWin(move, board)) {
                    break;
                }
            } else {
                break;
            }
        }
        referee.printWinner(move, firstPlayer);
    }

}
