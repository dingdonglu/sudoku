package Hw5;
public class SudokuSquareLinkedList {
	
private SudokuSquareNode head;
	

	public SudokuSquareLinkedList(SudokuSquareNode n){
		head = n;
	}
	
	public void print(){
		SudokuSquareNode current = head;
		while (current!=null){
			System.out.print(current.getData()+" ");
			current = current.getNext();
		}
	}
	
	public void append(SudokuSquare x){
		SudokuSquareNode current = head;
		while (current.getNext()!=null){
			current = current.getNext();
		}
		current.setNext(new SudokuSquareNode(x));
	}
	
	public SudokuSquare getNext(SudokuSquareNode n) {
		return n.getNext().getData();
	}

	
	
}
