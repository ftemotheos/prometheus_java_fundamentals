package week4.tic_tak_toe;

public enum ActionFigure {
	NOUGHT {
		@Override
		public String toString() {
			return String.valueOf(Character.toChars(0x2B58));
		}
	},
	CROSS {
		@Override
		public String toString() {
			return String.valueOf(Character.toChars(0x2573));
		}
	}
}
