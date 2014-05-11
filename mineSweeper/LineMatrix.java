/**
 * CodeEval Challenge: MINESWEEPER  (Hard Difficulty)
 * See included ReadMe for usage. 
 * @author Paul Salmon 
 * www.github.com/psalmon
 * Score: 100%
 */

package mineSweeper;

public class LineMatrix {
	private int m = 0; private int n = 0; //mXn matrix m rows, n columns
	private String input = "";
	private StringBuilder output = new StringBuilder();
	private static char matrix[][];
	public LineMatrix(String input){ //constructor
		this.input = input;
		parseLine();
	}
	
	private void parseLine(){
		String mn[] = input.split("\\D", 3);//regex to get m & n
		m = Integer.parseInt(mn[0]);
		n = Integer.parseInt(mn[1]);
		String inputTrim = input.replaceFirst("\\d,\\d;", "");
		
		buildMatrix(inputTrim);
		solveMatrix();
		buildOutputString();
	}
	
	private void buildMatrix(String inputTrim){
		int count = 0;
		matrix = new char[m][n]; //iniitalize the matrix to m by n
		for (int i = 0; i < m; i++){ //one column at a time
			for (int j = 0; j < n; j++){//fill each row per column
				matrix[i][j] = inputTrim.charAt(count);
				count++;
			}
		}
		
	}
	
	private void solveMatrix(){
		for (int i = 0; i < m; i++){//replace . with 0s.
			for (int j = 0; j < n; j++){
				if(matrix[i][j] == '.'){
					matrix[i][j] = '0';
				}
			}
		}
		
		
		for (int i = 0; i < m; i++){//check for mines and update counts
			for (int j = 0; j < n; j++){
				if(matrix[i][j] == '*'){
					updateNeighbors(i, j);
				}
				
			}
		}
	}
	
	private void buildOutputString(){
		for (int i = 0; i < m; i++){
			for (int j = 0; j < n; j++){
				output.append(matrix[i][j]);
			}
		}		
	}
	
	private void updateNeighbors(int i, int j){ //maximum 8 neighbours. Worst case is kind of very exponential...rare case but perhaps we can optimize by only checking for i+1, j+1..etc once, and then doing appropriate subchecks.
		if (j-1 >= 0 && matrix[i][j-1] != '*'){ matrix[i][j-1] = (char)(((int)matrix[i][j-1])+1); }
		if (j+1 < n && matrix[i][j+1] != '*'){ matrix[i][j+1] = (char)(((int)matrix[i][j+1])+1); }
		if (i-1 >= 0 && j-1 >= 0 && matrix[i-1][j-1] != '*'){ matrix[i-1][j-1] = (char)(((int)matrix[i-1][j-1])+1); }
		if (i-1 >= 0 && matrix[i-1][j] != '*'){ matrix[i-1][j] = (char)(((int)matrix[i-1][j])+1); }
		if (i-1 >=0 && j+1 < n && matrix[i-1][j+1] != '*'){ matrix[i-1][j+1] = (char)(((int)matrix[i-1][j+1])+1); }
		if (i+1 < m && j-1 >= 0 && matrix[i+1][j-1] != '*'){ matrix[i+1][j-1] = (char)(((int)matrix[i+1][j-1])+1); }
		if (i+1 < m && matrix[i+1][j] != '*'){ matrix[i+1][j] = (char)(((int)matrix[i+1][j])+1); }
		if (i+1 < m && j+1 < n && matrix[i+1][j+1] != '*'){ matrix[i+1][j+1] = (char)(((int)matrix[i+1][j+1])+1); }		
	}
	
	public String getOutput(){
		return output.toString();
	}
	
}
