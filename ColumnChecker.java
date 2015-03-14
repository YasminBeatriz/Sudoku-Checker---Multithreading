/* 
 * This class checks every single column of Sudoku grid
 * Author: Yasmin Beatriz Alves da Silva
 */

public class ColumnChecker implements Runnable {
	
	Sudoku grid;
	int[][] occurrence;
	int i, j, k;
	boolean answer = true;
	
	public ColumnChecker(Sudoku s)
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
				k = grid.sudoku[i][j] - 1; //The value of k - 1 in each singular column matches with its position in occurrence array
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
		grid.setAnswerColumn(answer);
	}

	/*public void printOccurrence()
	{
		System.out.println("(Column) Occurrence: ");
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
