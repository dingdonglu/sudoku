package Hw5;



import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MyGUI extends JFrame implements ActionListener {
	

	int row=0;
	int column=0;
	int value=0;
	JButton sudokuButton[][] = new JButton [4][4];
	JTextField txtInput;
	JTextArea textBox;
	JLabel txtLabel;
	
	
	SudokuBoard Sudoku = new SudokuBoard();
	
	
	public MyGUI() {
		
		JFrame jFrame = new JFrame("Sudoku game");
		jFrame.setSize(400,550);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLayout(new FlowLayout());
		
		textBox = new JTextArea(20,30);
		textBox.append("Welcome to sudoku game");

		textBox.setEditable(false);
		jFrame.add(textBox);

		
		
		JRadioButton validJB = new JRadioButton(" Check valid  ");
		JRadioButton enterJB = new JRadioButton(" Enter  ");
		JRadioButton clearJB = new JRadioButton(" Clear  ");		
		ButtonGroup SudokuButton = new ButtonGroup();
		jFrame.add(validJB);
		jFrame.add(enterJB);
		jFrame.add(clearJB);
		SudokuButton.add(validJB);
		SudokuButton.add(enterJB);
		SudokuButton.add(clearJB);
		
		validJB.setActionCommand("Valid");
		enterJB.setActionCommand("Enter");
		clearJB.setActionCommand("Clear");
		
		validJB.addActionListener(this);
		enterJB.addActionListener(this);
		clearJB.addActionListener(this);
		
		
		

		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4,4));
		jFrame.add(panel);
		
		for(int j=0; j<=3; j++) {
			for(int i=0; i<=3; i++) {
				
				int IntValue =Sudoku.array[i][j].getValue();
				String Value;
				
				if(IntValue==0) {
					Value = "";
				}
				else {
					Value = Integer.toString(IntValue);
				}
				
				sudokuButton[i][j] = new JButton(Value);
				
				String button1 = Integer.toString(i);
				String button2 = Integer.toString(j);
				sudokuButton[i][j].setActionCommand(button1+button2);
				
				panel.add(sudokuButton[i][j]);
				
				sudokuButton[i][j].addActionListener(this);
				
			}
		}
		
		
		
		txtLabel = new JLabel("Please input a value form 1 to 0.");
		
		jFrame.add(txtLabel);
		
		txtInput = new JTextField(8);
		
		jFrame.add(txtInput);

		txtInput.addActionListener(this);
	
		
		JButton reset = new JButton("RESET");
		
		jFrame.add(reset);
		
		reset.setActionCommand("reset");
		
		reset.addActionListener(this);
	
		
		jFrame.setVisible(true);
		
		

		
	}

	
	
	
public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().length()==2) {
			char button1=e.getActionCommand().charAt(0);
			char button2=e.getActionCommand().charAt(1);
			
			
			row = Character.getNumericValue(button1);
			column = Character.getNumericValue(button2);
			

		}
		
		
		
		else {
			
			switch(e.getActionCommand()) {
			
			case "Valid":
				
				try{
				value=Integer.parseInt(txtInput.getText());
				if(value <0|| value >4) throw new InterruptedException();
				if(Sudoku.isVaild(row, column, value)) {
					
					textBox.append("\n"+"You can input " + value + " into this square.");
					break;
					
					}
				}
				catch(InterruptedException ie){
					JOptionPane.showMessageDialog(null,"Illegal input. You must enter a number between 1 to 4.");
					textBox.append("\n"+"You cannot input " + value + " into this square.");
				}
				
				catch(NumberFormatException ie) {
	
					JOptionPane.showMessageDialog(null,"Illegal input. You must input a number.");
					

				}
				break;
			case "Clear":
				
				int cValue=Sudoku.array[row][column].getValue();
				
				if(Sudoku.isClearEntry(row,column)) {
					
					sudokuButton[row][column].setText("");
					
				}
				
				textBox.append("\n"+"The square (row=" + row + " column=" + column + " value=" + cValue +") has been clean.");
				break;
			
			
			case "Enter":
				
				try {
				
					value=Integer.parseInt(txtInput.getText());
					if(value <0|| value >4) throw new InterruptedException();
					if(Sudoku.isVaild(row,column,value)) {

						Sudoku.enterMove(row, column, value);
						
						textBox.append("\n"+"You input row=" + row + " column=" + column + " value=" + value + ".");
						
						String Stringvalue = Integer.toString(value);

						sudokuButton[row][column].setText(Stringvalue);
						
						if(Sudoku.isFull()) {
							
							textBox.append("\n"+"You have finish the game.");
							
							JOptionPane.showMessageDialog(null, "You have finish the game.");
							
							break;
						
						}
						
					}
					
					else {
						
						textBox.append("\n"+"The value doesn't be input.");
					
					}
				
				}
				catch(InterruptedException ex){
					JOptionPane.showMessageDialog(null,"Illegal input. You must enter a number between 1 to 4.");
				}
				
				catch(NumberFormatException ex) {
	
					JOptionPane.showMessageDialog(null,"Illegal input. You must input a number.");
					
				}
				
				

				break;
			
			
			
			case "reset":
				
				int resetResult = JOptionPane.showConfirmDialog(null,"Do you want to reset the board?","Reset the game",JOptionPane.YES_NO_OPTION);
				
				switch (resetResult) {
				case (JOptionPane.YES_OPTION):
					
					Sudoku.reset();
					
					for(int i=0;i<=3;i++) {
						for(int j=0;j<=3;j++) {
							if(Sudoku.array[i][j].isLocked()) {
								sudokuButton[i][j].setText("");
							}
						}
					
					}
					textBox.append("\n"+"The game has been reseted.");
					
				case(JOptionPane.NO_OPTION) :
					
					textBox.append("\n"+"Please continue play the game.");
					break;	
					
					
				}
				
			
			}
		
			
		}
				
	}

}





