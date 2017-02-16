package Hw5;


public class SudokuSquare {
	
	private int row;
	private int column;
	private int value=0;
	private boolean locked;
	

	public SudokuSquare() {	
	}
	
	public SudokuSquare(int r, int c, int v, boolean l) {
		row=r;
		column=c;
		locked=l;
		value=v;
		
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public int getValue() {
		return value;
	}
	
	public boolean isLocked() {
	
		return locked;
		
	}
	public SudokuSquare getSquare(SudokuSquare n){
		return n;
	}
	
	
	
	

}
