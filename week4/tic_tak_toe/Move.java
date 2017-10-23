package week4.tic_tak_toe;

public enum Move {
	TOP_LEFT(0,0), TOP_CENTER(0,1), TOP_RIGHT(0,2),
	MIDDLE_LEFT(1,0), MIDDLE_CENTER(1,1), MIDDLE_RIGHT(1,2),
	BOTTOM_LEFT(2,0), BOTTOM_CENTER(2,1), BOTTOM_RIGHT(2,2);

	private int x;

	private int y;

	private ActionFigure figure;

	Move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public ActionFigure getFigure() {
		return figure;
	}

	public void setFigure(ActionFigure figure) {
		this.figure = figure;
	}

}
