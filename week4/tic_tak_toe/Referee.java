package week4.tic_tak_toe;

public class Referee {

    public boolean check(Move move, Board board) {
        return move != null && board.getBoardState()[move.getX()][move.getY()] == null;
    }

	public void put(Move move, Board board) {
		board.changeBoardState(move);
	}

	public boolean isWin(Move move, Board board) {
        return board.isBoardStateWin(move);
	}

    public void printAttention() {
        System.out.println("The specified position is already occupied!");
        System.out.println();
    }

	public void printWinner(Move move, Player firstPlayer, Player secondPlayer) {
		if (move == null) System.out.println("No one is winner!");
		else System.out.println((move.getFigure() == firstPlayer.getFigure() ? firstPlayer.toString() : secondPlayer.toString()) + " is winner!");
	}

    public void printWinner(Move move, Player player) {
        if (move == null) System.out.println("No one is winner!");
        else System.out.println((move.getFigure() == player.getFigure() ? player.toString() + " is" : "You are") + " winner!");
    }

}
