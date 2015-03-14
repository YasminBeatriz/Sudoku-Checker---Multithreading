/* 
 * This class checks every single row of Sudoku grid
 * Author: Yasmin Beatriz Alves da Silva
 */

public class RowChecker implements Runnable {
	
	Sudoku grid;
	int[][] occurrence;
	int i, j, k;
	boolean answer = true;
	
	public RowChecker(Sudoku s)
	{
		grid = s;
	}
	
	public void run()
	{	
		occurrence = new int[9][9];
			
		for(i = 0; i < 9; i++)
		{
			for(j = 0; j < 9; j++)
			{
				k = grid.sudoku[i][j] - 1; //The value of k - 1 in each singular row matches with its position in occurrence array
				occurrence[i][k]++;
			}
		}
		
		//The values in occurrence array may be more or less than 1, it means that the sudoku solution is wrong
		for(i = 0; i < 9; i++)
		{
			for(j = 0; j < 9; j++)
			{
				if(occurrence[i][j] != 1)
					answer = false;
			}
		}
		grid.setAnswerRow(answer);
		
	}
	
	/*public void printOccurrence()
	{
		System.out.println("(Row) Occurrence: ");
		for(i = 0; i < 9; i++)
		{
			for(j = 0; j < 9; j++)
			{
				System.out.print(occurrence[i][j] + " ");
			}
			System.out.println();
		}
	}*/
}
