/* 
 * This class implements an object of Sudoku, with its array of integers, and boolean values that says if the rows, columns and 
 * subgrids are with valid values
 * Author: Yasmin Beatriz Alves da Silva
 */

public class Sudoku {
	protected int[][] sudoku;
	boolean row, column, subgrid;
	
	public Sudoku(int[][] arr)
	{
		sudoku = arr;
	}
	
	public void setAnswerRow(boolean a)
	{
		row = a;
	}
	
	public boolean getAnswerRow()
	{
		return row;
	}
	
	public void setAnswerColumn(boolean a)
	{
		column = a;
	}
	
	public boolean getAnswerColumn()
	{
		return column;
	}
	
	public void setAnswerSubGrid(boolean a)
	{
		subgrid = a;
	}
	
	public boolean getAnswerSubGrid()
	{
		return subgrid;
	}
}
