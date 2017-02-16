package Hw5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SudokuBoard {
	
	public SudokuSquare array[][] = new SudokuSquare [4][4];
	
	private SudokuSquareLinkedList board;

	
	public SudokuBoard() {
		
		array[0][0]= new SudokuSquare(0,0,0,true);
		board= new SudokuSquareLinkedList (new SudokuSquareNode(array[0][0]));
		
		for(int i=0;i<=3;i++) {
			for(int j=0;j<=3;j++) {
				array[i][j]= new SudokuSquare(i,j,0,true);
				board.append(array[i][j]);
			}
		}
		
		readFile();
		
	}
	
	public boolean isVaild(int r, int c, int v) {
			return (array[r][c].isLocked() && checkEntry(r,c,v)) ;
	}
	
	public boolean checkEntry(int r, int c, int v) {
		
		for(int i =0; i<4;i++){
			if(v==array[r][i].getValue()){
				JOptionPane.showMessageDialog(null, "There is a "+v+" is the same column line.");
				return false;
				
			}
		}
		for(int j = 0; j<4; j++){
			if(v==array[j][c].getValue()){
				JOptionPane.showMessageDialog(null, "There is a "+v+" is the same row line.");
				return false;
			}
		}
		for (int row = (r / 2) * 2; row < (r / 2) * 2 + 2; row++){
		  	  for (int col = (c / 2) * 2; col < (c / 2) * 2 + 2; col++){
				if (row != r && col != c && array[row][col].getValue() == v){
					JOptionPane.showMessageDialog(null, "Aleady have " +v+ " in the 2*2 square");
					return false;
				}
	  	  }
		}
		return true;
	}
	
	public void enterMove(int r, int c, int v) {
		
		if(isVaild(r,c,v)==true) {
			array[r][c]= new SudokuSquare(r,c,v,true);
			board.append(array[r][c]);
		}

	}
	
	public void reset() {
		for(int r=0;r<=3;r++) {
			for(int c=0;c<=3;c++) {
				if(array[r][c].isLocked()) {
					array[r][c]= new SudokuSquare(r,c,0,true);
					board.append(array[r][c]);
				}
			}
		}
	}
	
	
	public boolean isFull() {
		for(int i=0; i<=3;i++) {
			for(int j=0;j<=3;j++) {
				if(array[i][j].getValue()==0){
					return false;
				};
			}
		}
		
		return true;
	}
	
	
	public boolean isClearEntry (int r, int c) {
		if(array[r][c].isLocked()) {
			array[r][c]= new SudokuSquare(r,c,0,true);
			board.append(array[r][c]);
			return true;
		}
		else {
			return false;
		}
	}
	

	public void readFile() {
		
		try {
			Scanner scn = new Scanner(new File("/Users/ting-yuanlu/Documents/workspace/Cs212/src/Hw5/Input.txt"));
			scn.nextLine();
			
			while(scn.hasNext()) {
				
				int row = scn.nextInt();
				int column = scn.nextInt();
				int value = scn.nextInt();
				
				array[row][column]= new SudokuSquare(row,column,value,false);
			
			}
		
		}
		
		catch(FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
}
