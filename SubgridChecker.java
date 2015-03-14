/* 
 * This class checks every single subgrid 3x3 of Sudoku grid
 * Author: Yasmin Beatriz Alves da Silva
 */
public class SubgridChecker implements Runnable {
	
	Sudoku grid;
	int[][] occurrence;
	int i, j, k, l, m;
	int a, b, c;
	boolean answer = true;
	
	public SubgridChecker(Sudoku s)
	{
		grid = s;
	}
	
	public void run()
	{	
		occurrence = new int[9][9];
		
		for(i = 0; i < 9; i+=3)
		{
			for(j = 0; j < 9; j+=3)
			{
				//System.out.println(" [" + i + "][" + j + "]\t");
				for(a = 0; a < 3; a++)
				{
					for(b = 0; b < 3; b++)
					{
						//System.out.print(" " + grid.sudoku[a+i][b+j]);
						k = grid.sudoku[a+i][b+j] - 1;
						
						//Insert in occurrence[][] array the number of times the number k appeared in sudoku
						//The index in each subgrid of sudoku matches with the value of k - 1
						//As well as the index of rows and columns, used in the other threads
						
						int count = 0;
						for(l = 0; l < 3; l++)
						{
							for(m = 0; m < 3; m++)
							{
								if(count == k)
								{
									occurrence[l+i][m+j]++;
									//System.out.println("Inseriu k = " + k + " em: ");
									//System.out.println("[" + (l+i) + "]" + "[" + (m+j) + "]");
									//System.out.println();
									l = 4;
									break;
								}
								//System.out.println("Count: " + count);
								count++;
							}
						}
						//End of insertion
					}
					//System.out.println();
				}
			}
			//System.out.println();
		}
		
		//printOccurrence();
		
		//The values in occurrence array may be more or less than 1, it means that the sudoku solution is wrong
		for(i = 0; i < 9; i+=3)
			for(j = 0; j < 9; j+=3)
				for(a = 0; a < 3; a++)
					for(b = 0; b < 3; b++)
					{
						if(occurrence[a+i][b+j] != 1)
							answer = false;
					}
		
		grid.setAnswerSubGrid(answer);
	}
	
	public void printOccurrence()
	{	
		System.out.println("(Subgrid) Occurrence: ");
		for(i = 0; i < 9; i+=3)
		{
			for(j = 0; j < 9; j+=3)
			{
				System.out.println(" [" + i + "][" + j + "]\t");
				for(a = 0; a < 3; a++)
				{
					for(b = 0; b < 3; b++)
					{
						System.out.print(" " + occurrence[a+i][b+j]);
					}
					System.out.println();
				}
			}
			System.out.println();
		}
	}


}
