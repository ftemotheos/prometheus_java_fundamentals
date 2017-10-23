package week4.tic_tak_toe;

public class ForkingMoveStrategy extends Strategy {

    @Override
    public Move getMove(ActionFigure figure, ActionFigure[][] boardState) {
        ActionFigure opponentFigure;
        if (figure == ActionFigure.NOUGHT) {
            opponentFigure = ActionFigure.CROSS;
        }
        else {
            opponentFigure = ActionFigure.NOUGHT;
        }
        Move move = getForkingMove(figure, boardState);
        if (move == null) {
            move = getForkingMove(opponentFigure, boardState);
        }
        if (move != null) {
            move.setFigure(figure);
        }
        return move;
    }

    private Move getForkingMove(ActionFigure figure, ActionFigure[][] boardState) {
        Move[] positions = Move.values();
        Move move;
        ActionFigure availableFigureInTheRow = null;
        ActionFigure availableFigureInTheColumn = null;
        ActionFigure availableFigureInTheDiagonalLTRB = null;
        ActionFigure availableFigureInTheDiagonalLBRT = null;
        int diagonalLTRBEmptyCellCounter = 0;
        int diagonalLBRTEmptyCellCounter = 0;
        int indexFirstRowWithForkingOpportunities = -1;
        int indexSecondRowWithForkingOpportunities = -1;
        int indexFirstColumnWithForkingOpportunities = -1;
        int indexSecondColumnWithForkingOpportunities = -1;
        for (int i = 0; i < boardState.length; i++) {
            int rowEmptyCellCounter = 0;
            int columnEmptyCellCounter = 0;
            for (int j = 0; j < boardState[i].length; j++) {
                if (boardState[i][j] == null) {
                    rowEmptyCellCounter++;
                }
                else {
                    if (boardState[i][j] == figure) {
                        availableFigureInTheRow = boardState[i][j];
                    }
                }
                if (boardState[j][i] == null) {
                    columnEmptyCellCounter++;
                }
                else {
                    if (boardState[j][i] == figure) {
                        availableFigureInTheColumn = boardState[j][i];
                    }
                }
            }
            if (rowEmptyCellCounter == Board.SERIES - 1 && availableFigureInTheRow != null) {
                if (indexFirstRowWithForkingOpportunities == -1) {
                    indexFirstRowWithForkingOpportunities = i;
                }
                else {
                    indexSecondRowWithForkingOpportunities = i;
                }
            }
            if (columnEmptyCellCounter == Board.SERIES - 1 && availableFigureInTheColumn != null) {
                if (indexFirstColumnWithForkingOpportunities == -1) {
                    indexFirstColumnWithForkingOpportunities = i;
                }
                else {
                    indexSecondColumnWithForkingOpportunities = i;
                }
            }
            if (boardState[i][i] == null) {
                diagonalLTRBEmptyCellCounter++;
            }
            else {
                if (boardState[i][i] == figure) {
                    availableFigureInTheDiagonalLTRB = boardState[i][i];
                }
            }
            if (boardState[i][boardState.length - 1 - i] == null) {
                diagonalLBRTEmptyCellCounter++;
            }
            else {
                if (boardState[i][boardState.length - 1 - i] == figure) {
                    availableFigureInTheDiagonalLBRT = boardState[i][boardState.length - 1 - i];
                }
            }
            availableFigureInTheRow = null;
            availableFigureInTheColumn = null;
        }
        if (indexFirstRowWithForkingOpportunities != -1 && indexFirstColumnWithForkingOpportunities != -1) {
            move = positions[indexFirstRowWithForkingOpportunities * boardState[indexFirstRowWithForkingOpportunities].length + indexFirstColumnWithForkingOpportunities];
            if (move.getFigure() == null) {
                return move;
            }
        }
        if (indexFirstRowWithForkingOpportunities != -1 && indexSecondColumnWithForkingOpportunities != -1) {
            move = positions[indexFirstRowWithForkingOpportunities * boardState[indexFirstRowWithForkingOpportunities].length + indexSecondColumnWithForkingOpportunities];
            if (move.getFigure() == null) {
                return move;
            }
        }
        if (indexSecondRowWithForkingOpportunities != -1 && indexFirstColumnWithForkingOpportunities != -1) {
            move = positions[indexSecondRowWithForkingOpportunities * boardState[indexSecondRowWithForkingOpportunities].length + indexFirstColumnWithForkingOpportunities];
            if (move.getFigure() == null) {
                return move;
            }
        }
        if (indexSecondRowWithForkingOpportunities != -1 && indexSecondColumnWithForkingOpportunities != -1) {
            move = positions[indexSecondRowWithForkingOpportunities * boardState[indexSecondRowWithForkingOpportunities].length + indexSecondColumnWithForkingOpportunities];
            if (move.getFigure() == null) {
                return move;
            }
        }
        if (diagonalLTRBEmptyCellCounter == Board.SERIES - 1 && availableFigureInTheDiagonalLTRB != null) {
            if (indexFirstRowWithForkingOpportunities != -1) {
                move = positions[indexFirstRowWithForkingOpportunities * boardState[indexFirstRowWithForkingOpportunities].length + indexFirstRowWithForkingOpportunities];
                if (move.getFigure() == null) {
                    return move;
                }
            }
            if (indexSecondRowWithForkingOpportunities != -1) {
                move = positions[indexSecondRowWithForkingOpportunities * boardState[indexSecondRowWithForkingOpportunities].length + indexSecondRowWithForkingOpportunities];
                if (move.getFigure() == null) {
                    return move;
                }
            }
            if (indexFirstColumnWithForkingOpportunities != -1) {
                move = positions[indexFirstColumnWithForkingOpportunities * boardState[indexFirstColumnWithForkingOpportunities].length + indexFirstColumnWithForkingOpportunities];
                if (move.getFigure() == null) {
                    return move;
                }
            }
            if (indexSecondColumnWithForkingOpportunities != -1) {
                move = positions[indexSecondColumnWithForkingOpportunities * boardState[indexSecondColumnWithForkingOpportunities].length + indexSecondColumnWithForkingOpportunities];
                if (move.getFigure() == null) {
                    return move;
                }
            }
        }
        if (diagonalLBRTEmptyCellCounter == Board.SERIES - 1 && availableFigureInTheDiagonalLBRT != null) {
            if (indexFirstRowWithForkingOpportunities != -1) {
                move = positions[indexFirstRowWithForkingOpportunities * boardState[indexFirstRowWithForkingOpportunities].length + boardState[indexFirstRowWithForkingOpportunities].length - 1 - indexFirstRowWithForkingOpportunities];
                if (move.getFigure() == null) {
                    return move;
                }
            }
            if (indexSecondRowWithForkingOpportunities != -1) {
                move = positions[indexSecondRowWithForkingOpportunities * boardState[indexSecondRowWithForkingOpportunities].length + indexSecondRowWithForkingOpportunities];
                if (move.getFigure() == null) {
                    return move;
                }
            }
            if (indexFirstColumnWithForkingOpportunities != -1) {
                move = positions[indexFirstColumnWithForkingOpportunities * boardState[indexFirstColumnWithForkingOpportunities].length + boardState[indexFirstColumnWithForkingOpportunities].length - 1 - indexFirstColumnWithForkingOpportunities];
                if (move.getFigure() == null) {
                    return move;
                }
            }
            if (indexSecondColumnWithForkingOpportunities != -1) {
                move = positions[indexSecondColumnWithForkingOpportunities * boardState[indexSecondColumnWithForkingOpportunities].length + indexSecondColumnWithForkingOpportunities];
                if (move.getFigure() == null) {
                    return move;
                }
            }
            if (diagonalLTRBEmptyCellCounter == Board.SERIES - 1 && figure == availableFigureInTheDiagonalLTRB) {
                move = Move.MIDDLE_CENTER;
                if (move.getFigure() == null) {
                    return move;
                }
            }
        }
        return null;
    }

}
