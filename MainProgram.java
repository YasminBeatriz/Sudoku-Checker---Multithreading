/* This is the program that runs all the threads 
 * It receives an input from a file 
 * Author: Yasmin Beatriz Alves da Silva */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class MainProgram {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		
		String line;
		String[] chars;
		BufferedReader buffer;
		int[][] array = new int[9][9];
		Sudoku sudoku;
		Boolean right;
		
		//Use the following three solutions below:	
		//buffer = new BufferedReader(new FileReader("src/SudokuCorrect.txt"));
		//buffer = new BufferedReader(new FileReader("src/SudokuIncorrect1.txt"));
		buffer = new BufferedReader(new FileReader("src/SudokuIncorrect2.txt"));
		
		int i = 0;
		while((line = buffer.readLine()) != null)
		{
			chars = line.split(" ");
			
			for(int j = 0; j < 9; j++)
			{
					array[i][j] = Integer.parseInt(chars[j]);
			}
			i++;
		}
		
		sudoku = new Sudoku(array);
		
		Thread thrdRow = new Thread(new RowChecker(sudoku));
		Thread thrdColumn = new Thread(new ColumnChecker(sudoku));
		Thread thrdSubgrid = new Thread(new SubgridChecker(sudoku));
		
		thrdRow.start();
		thrdColumn.start();
		thrdSubgrid.start();
		
		try
		{
			thrdRow.join();
			thrdColumn.join();
			thrdSubgrid.join();
		
			Writer output;	
			try
			{
				//output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream ("OutputSudokuCorrect.txt"), "utf-8"));
				//output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream ("OutputSudokuIncorrect1.txt"), "utf-8"));
				output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream ("OutputSudokuIncorrect2.txt"), "utf-8"));
				
				if(sudoku.getAnswerRow() && sudoku.getAnswerColumn() && sudoku.getAnswerSubGrid())
					output.write("The answer for this Sudoku is: true");
				else
					output.write("The answer for this Sudoku is: false");
				
				output.close();
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		}
		catch(InterruptedException ex)
		{
			ex.printStackTrace();
		}
		buffer.close();		
	}
}
