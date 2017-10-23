package week4.tic_tak_toe;

public class PlayComputerWithComputerCommand implements Command {

    private Player firstPlayer;

    private Player secondPlayer;

    public PlayComputerWithComputerCommand(Player firstPlayer, Player secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    @Override
    public void execute(Referee referee, Board board) {
        Move move;
        while(true) {
            if ((move = TheGame.computerRound(referee, firstPlayer, board)) != null) {
                if (TheGame.roundsCounter > 4 && referee.isWin(move, board)) {
                    break;
                }
            }
            else {
                break;
            }
            if ((move = TheGame.computerRound(referee, secondPlayer, board)) != null) {
                if (TheGame.roundsCounter > 4 && referee.isWin(move,board)) {
                    break;
                }
            }
            else {
                break;
            }
        }
        referee.printWinner(move, firstPlayer, secondPlayer);
    }

}
