package Hw5;

public class Assignment5 {
	
	public static void main(String[] args) {
		
		
		
		MyGUI sdkGui = new MyGUI();
		
		
	}
	
	


	public static boolean test(SudokuBoard game) {
		for(int i=0; i<=3;i++) {
			for(int j=0;j<=3;j++) {
				if(game.array[i][j].getValue()==0){
					return false;
				};
				
			}
		}
		
		return true;
	}
	
	
	
	
}
