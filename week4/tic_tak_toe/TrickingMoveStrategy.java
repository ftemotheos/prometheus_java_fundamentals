package week4.tic_tak_toe;

public class TrickingMoveStrategy extends Strategy {

    @Override
    public Move getMove(ActionFigure figure, ActionFigure[][] boardState) {
        Move[] positions = Move.values();
        Move move;
        int diagonalLTRBOccupiedCellCounter = 0;
        int diagonalLBRTOccupiedCellCounter = 0;
        int diagonalLTRBEmptyCellIndex = -1;
        int diagonalLBRTEmptyCellIndex = -1;
        int currentFigureOccupiedCellFirstIndex = -1;
        int currentFigureOccupiedCellSecondIndex = -1;
        for (int i = 0; i < boardState.length; i++) {
            for (int j = 0; j < boardState[i].length; j++) {
                if (boardState[i][j] == figure) {
                    currentFigureOccupiedCellFirstIndex = i;
                    currentFigureOccupiedCellSecondIndex = j;
                }
            }
            if (boardState[i][i] != null) {
                diagonalLTRBOccupiedCellCounter++;
            }
            else {
                diagonalLTRBEmptyCellIndex = i;
            }
            if (boardState[i][boardState.length - 1 - i] != null) {
                diagonalLBRTOccupiedCellCounter++;
            }
            else {
                diagonalLBRTEmptyCellIndex = i;
            }
        }
        if (diagonalLTRBOccupiedCellCounter == Board.SERIES - 1) {
            move = positions[diagonalLTRBEmptyCellIndex * boardState[diagonalLTRBEmptyCellIndex].length + diagonalLTRBEmptyCellIndex];
            if (move.getFigure() == null) {
                move.setFigure(figure);
                return move;
            }
        }
        if (diagonalLBRTOccupiedCellCounter == Board.SERIES - 1) {
            move = positions[diagonalLBRTEmptyCellIndex * boardState[diagonalLBRTEmptyCellIndex].length + boardState[diagonalLBRTEmptyCellIndex].length - 1 - diagonalLBRTEmptyCellIndex];
            if (move.getFigure() == null) {
                move.setFigure(figure);
                return move;
            }
        }
        Move[] newPositions = new Move[(boardState.length - 1) * (boardState.length - 1)];
        int k = 0;
        for (int i = 0; i < boardState.length; i++) {
            if (i == currentFigureOccupiedCellFirstIndex) {
                continue;
            }
            for (int j = 0; j < boardState.length; j++) {
                if (j == currentFigureOccupiedCellSecondIndex) {
                    continue;
                }
                newPositions[k] = positions[i * boardState.length + j];
                k++;
            }
        }
        move = getRandomChoiceMove(newPositions);
        if (move != null) {
            move.setFigure(figure);
        }
        return move;
    }

}
