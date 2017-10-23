package week4.tic_tak_toe;

public class FinishingMoveStrategy extends Strategy {

    @Override
    public Move getMove(ActionFigure figure, ActionFigure[][] boardState) {
        ActionFigure opponentFigure;
        if (figure == ActionFigure.NOUGHT) {
            opponentFigure = ActionFigure.CROSS;
        }
        else {
            opponentFigure = ActionFigure.NOUGHT;
        }
        Move move = getFinishingMove(figure, boardState);
        if (move == null) {
            move = getFinishingMove(opponentFigure, boardState);
        }
        if (move != null) {
            move.setFigure(figure);
        }
        return move;
    }

    private Move getFinishingMove(ActionFigure figure, ActionFigure[][] boardState) {
        Move[] positions = Move.values();
        Move move;
        int diagonalLTRBOccupiedCellCounter = 0;
        int diagonalLBRTOccupiedCellCounter = 0;
        int diagonalLTRBEmptyCellIndex = -1;
        int diagonalLBRTEmptyCellIndex = -1;
        for (int i = 0; i < boardState.length; i++) {
            int rowOccupiedCellCounter = 0;
            int columnOccupiedCellCounter = 0;
            int emptyCellFirstIndex = -1;
            int emptyCellSecondIndex = -1;
            for (int j = 0; j < boardState[i].length; j++) {
                if (figure == boardState[i][j]) {
                    rowOccupiedCellCounter++;
                }
                else {
                    emptyCellSecondIndex = j;
                }
                if (figure == boardState[j][i]) {
                    columnOccupiedCellCounter++;
                }
                else {
                    emptyCellFirstIndex = j;
                }
            }
            if (rowOccupiedCellCounter == Board.SERIES - 1) {
                move = positions[i * boardState[i].length + emptyCellSecondIndex];
                if (move.getFigure() == null) {
                    return move;
                }
            }
            if (columnOccupiedCellCounter == Board.SERIES - 1) {
                move = positions[emptyCellFirstIndex * boardState[emptyCellFirstIndex].length + i];
                if (move.getFigure() == null) {
                    return move;
                }
            }
            if (figure == boardState[i][i]) {
                diagonalLTRBOccupiedCellCounter++;
            }
            else {
                diagonalLTRBEmptyCellIndex = i;
            }
            if (figure == boardState[i][boardState.length - 1 - i]) {
                diagonalLBRTOccupiedCellCounter++;
            }
            else {
                diagonalLBRTEmptyCellIndex = i;
            }
        }
        if (diagonalLTRBOccupiedCellCounter == Board.SERIES - 1) {
            move = positions[diagonalLTRBEmptyCellIndex * boardState[diagonalLTRBEmptyCellIndex].length + diagonalLTRBEmptyCellIndex];
            if (move.getFigure() == null) {
                return move;
            }
        }
        if (diagonalLBRTOccupiedCellCounter == Board.SERIES - 1) {
            move = positions[diagonalLBRTEmptyCellIndex * boardState[diagonalLBRTEmptyCellIndex].length + boardState[diagonalLBRTEmptyCellIndex].length - 1 - diagonalLBRTEmptyCellIndex];
            if (move.getFigure() == null) {
                return move;
            }
        }
        return null;
    }

}
