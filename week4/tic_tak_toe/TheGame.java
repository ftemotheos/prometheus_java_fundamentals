package week4.tic_tak_toe;

import java.util.Scanner;

public class TheGame {

    public static int roundsCounter = 1;

    private static Scanner scanner = new Scanner(System.in);

    private static Command command;

	public static void main(String[] args) {
        Referee referee = new Referee();
        Board board = new Board();
        Player firstPlayer = new Player(ActionFigure.CROSS);
        Player secondPlayer = new Player(ActionFigure.NOUGHT);
        boolean isChoiceDone = false;
        while(!isChoiceDone) {
            System.out.print("Do you want to play with computer by yourself? (Y/N): ");
            String answer = scanner.nextLine();
            switch (answer) {
                case "Y":
                case "y":
                    while(!isChoiceDone) {
                        System.out.print("Do you want to play a cross or nought? (C/N): ");
                        answer = scanner.nextLine();
                        switch (answer) {
                            case "C":
                            case "c":
                                command = new PlayCrossWithComputerCommand(secondPlayer);
                                isChoiceDone = true;
                                break;
                            case "N":
                            case "n":
                                command = new PlayNoughtWithComputerCommand(firstPlayer);
                                isChoiceDone = true;
                                break;
                            default:
                        }
                    }
                    break;
                case "N":
                case "n":
                    command = new PlayComputerWithComputerCommand(firstPlayer, secondPlayer);
                    isChoiceDone = true;
                    break;
                default:
            }
        }
        command.execute(referee, board);
        scanner.close();
	}

    public static Move computerRound(Referee referee, Player player, Board board) {
        if (!board.hasMoreSpace()) return null;
        Move move = player.turn(board);
        referee.put(move, board);
        System.out.println("The move of the " + player + " is:");
        board.print();
        roundsCounter++;
        return move;
    }

    public static Move humanRound(Referee referee, ActionFigure humanFigure, Board board) {
        if (!board.hasMoreSpace()) return null;
        Move move = null;
        boolean isChoiceDone = false;
        while (true) {
            while(!isChoiceDone) {
                System.out.println("Please, enter the position where you want to place the figure:");
                System.out.print("\t(TL)\t(TC)\t(TR)\n\t(ML)\t(MC)\t(MR)\n\t(BL)\t(BC)\t(BR)\nPosition is: ");
                String answer = scanner.nextLine();
                switch (answer) {
                    case "TL":
                    case "tl":
                        move = Move.TOP_LEFT;
                        isChoiceDone = true;
                        break;
                    case "TC":
                    case "tc":
                        move = Move.TOP_CENTER;
                        isChoiceDone = true;
                        break;
                    case "TR":
                    case "tr":
                        move = Move.TOP_RIGHT;
                        isChoiceDone = true;
                        break;
                    case "ML":
                    case "ml":
                        move = Move.MIDDLE_LEFT;
                        isChoiceDone = true;
                        break;
                    case "MC":
                    case "mc":
                        move = Move.MIDDLE_CENTER;
                        isChoiceDone = true;
                        break;
                    case "MR":
                    case "mr":
                        move = Move.MIDDLE_RIGHT;
                        isChoiceDone = true;
                        break;
                    case "BL":
                    case "bl":
                        move = Move.BOTTOM_LEFT;
                        isChoiceDone = true;
                        break;
                    case "BC":
                    case "bc":
                        move = Move.BOTTOM_CENTER;
                        isChoiceDone = true;
                        break;
                    case "BR":
                    case "br":
                        move = Move.BOTTOM_RIGHT;
                        isChoiceDone = true;
                        break;
                    default:
                }
            }
            if (referee.check(move, board)) {
                move.setFigure(humanFigure);
                referee.put(move, board);
                System.out.println("You play \"" + humanFigure + "\" and your move is:");
                board.print();
                roundsCounter++;
                return move;
            }
            else {
                referee.printAttention();
                isChoiceDone = false;
            }
        }
    }

}
