package week4.tic_tak_toe;

public class Board {

    public static final int ROWS = 3;

    public static final int COLUMNS = 3;

    public static final int SERIES = 3;

    private ActionFigure[][] board = new ActionFigure[ROWS][COLUMNS];

    private int emptyCell = ROWS * COLUMNS;

	public boolean hasMoreSpace() {
		return emptyCell > 0;
	}

    public ActionFigure[][] getBoardState() {
        ActionFigure[][] state = new ActionFigure[ROWS][COLUMNS];
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(board[i], 0, state[i], 0, board[i].length);
        }
        return state;
    }

    public void changeBoardState(Move move) {
        board[move.getX()][move.getY()] = move.getFigure();
        emptyCell--;
    }

    public boolean isBoardStateWin(Move move) {
        ActionFigure figure = move.getFigure();
        int diagonalLeftTopRightBottomCounter = 0;
        int diagonalLeftBottomRightTopCounter = 0;
        for (int i = 0; i < board.length; i++) {
            int rowCounter = 0;
            int columnCounter = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (figure == board[i][j]) {
                    rowCounter++;
                }
                if (figure == board[j][i]) {
                    columnCounter++;
                }
            }
            if (rowCounter == SERIES || columnCounter == SERIES) {
                return true;
            }
            if (figure == board[i][i])  {
                diagonalLeftTopRightBottomCounter++;
            }
            if (figure == board[i][board.length - 1 - i]) {
                diagonalLeftBottomRightTopCounter++;
            }
        }
        return diagonalLeftTopRightBottomCounter == SERIES || diagonalLeftBottomRightTopCounter == SERIES;
    }

	public void print() {
        int borderHorizontalLine = 0x2500;
        int borderVerticalLine = 0x2502;
        int borderLeftTopCorner = 0x250C;
        int borderRightTopCorner = 0x2510;
        int borderLeftBottomCorner = 0x2514;
        int borderRightBottomCorner = 0x2518;
        int borderLeftCross = 0x251C;
        int borderTopCross = 0x252C;
        int borderRightCross = 0x2524;
        int borderBottomCross = 0x2534;
        int borderCentralCross = 0x253C;
        int wideSpace = 0x3000;
        System.out.print(Character.toChars(borderLeftTopCorner));
        for (int k = 0; k < 11; k++) {
            if ((k + 1) % 4 == 0) {
                System.out.print(Character.toChars(borderTopCross));
                continue;
            }
            System.out.print(Character.toChars(borderHorizontalLine));
        }
        System.out.println(Character.toChars(borderRightTopCorner));
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(Character.toChars(borderVerticalLine));
                if (board[i][j] != null) {
                    System.out.print(Character.toChars(wideSpace));
                    System.out.print(board[i][j]);
                    System.out.print(Character.toChars(wideSpace));
                }
                else {
                    for (int k = 0; k < 3; k++) {
                        System.out.print(Character.toChars(wideSpace));
                    }
                }
            }
            System.out.println(Character.toChars(borderVerticalLine));
            if (i != board.length - 1) {
                System.out.print(Character.toChars(borderLeftCross));
                for (int k = 0; k < 11; k++) {
                    if ((k + 1) % 4 == 0) {
                        System.out.print(Character.toChars(borderCentralCross));
                        continue;
                    }
                    System.out.print(Character.toChars(borderHorizontalLine));
                }
                System.out.println(Character.toChars(borderRightCross));
            }
        }
        System.out.print(Character.toChars(borderLeftBottomCorner));
        for (int k = 0; k < 11; k++) {
            if ((k + 1) % 4 == 0) {
                System.out.print(Character.toChars(borderBottomCross));
                continue;
            }
            System.out.print(Character.toChars(borderHorizontalLine));
        }
        System.out.println(Character.toChars(borderRightBottomCorner));
    }

}
