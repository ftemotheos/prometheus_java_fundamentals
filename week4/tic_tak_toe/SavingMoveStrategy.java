package week4.tic_tak_toe;

public class SavingMoveStrategy extends Strategy {

    @Override
    public Move getMove(ActionFigure figure, ActionFigure[][] boardState) {
        Move[] positions = Move.values();
        boolean isCentral = false;
        int diagonalLTRBOccupiedCellCounter = 0;
        int diagonalLBRTOccupiedCellCounter = 0;
        int thisPlayerFigureFirstIndex = -1;
        int thisPlayerFigureSecondIndex = -1;
        for (int i = 0; i < boardState.length; i++) {
            if (boardState[i][i] != null) {
                diagonalLTRBOccupiedCellCounter++;
                if (figure == boardState[i][i]) {
                    thisPlayerFigureFirstIndex = thisPlayerFigureSecondIndex = i;
                }
            }
            if (boardState[i][boardState.length - 1 - i] != null) {
                diagonalLBRTOccupiedCellCounter++;
                if (figure == boardState[i][boardState.length - 1 - i]) {
                    if (thisPlayerFigureFirstIndex == i && thisPlayerFigureSecondIndex == boardState.length - 1 - i) {
                        isCentral = true;
                    }
                    else {
                        thisPlayerFigureFirstIndex = i;
                        thisPlayerFigureSecondIndex = boardState.length - 1 - i;
                    }
                }
            }
        }
        if (diagonalLTRBOccupiedCellCounter == Board.SERIES || diagonalLBRTOccupiedCellCounter == Board.SERIES) {
            Move[] newPositions = new Move[(boardState.length - 1) * (boardState.length - 1)];
            int k = 0;
            if (isCentral) {
                for (int i = 0; i < boardState.length; i++) {
                    if (boardState[i][thisPlayerFigureSecondIndex] == null) {
                        newPositions[k] = positions[i * boardState.length + thisPlayerFigureFirstIndex];
                        k++;
                    }
                    if (boardState[thisPlayerFigureFirstIndex][i] == null) {
                        newPositions[k] = positions[thisPlayerFigureFirstIndex * boardState.length + i];
                        k++;
                    }
                }
            }
            else {
                for (int i = 0; i < boardState.length; i++) {
                    if (boardState[i][i] == null) {
                        newPositions[k] = positions[i * boardState.length + i];
                        k++;
                    }
                    if (boardState[i][boardState.length - 1 - i] == null) {
                        newPositions[k] = positions[i * boardState.length + boardState.length - 1 - i];
                        k++;
                    }
                }
            }
            Move move = getRandomChoiceMove(newPositions);
            if (move != null) {
                move.setFigure(figure);
            }
            return move;
        }
        return null;
    }

}
