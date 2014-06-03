/*
 * Author: Paul Salmon
 * Code Eval: Word Search (Hard Difficulty)
 * Score: 97.5/100% (Possible error in grading system)
 * See included readme for usage.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Word_Search {
	public static final char[][] MATRIX = {	//constant for the sake of this problem. Can be changed for other uses...just keep it balanced.
					   {'A', 'B', 'C', 'E'},
					   {'S', 'F', 'C', 'S'},
		               {'A', 'D', 'E', 'E'}
					   };

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader inputFile = new BufferedReader(new FileReader(args[0]));
		doMagic(inputFile);
		System.exit(0);
	}
	
	public static void doMagic(BufferedReader file) throws IOException{
		BufferedReader inputFile = file;
		while(true){
			boolean found = false;	//did we trace the word?
			String line = inputFile.readLine();
			if(line == null){break;}//end of file
			
			found = startingPoint(line);
			if(found){
				System.out.println("True");
			}else{ System.out.println("False");}
		}
		inputFile.close();
	}
	
	public static boolean startingPoint(String line){
		char[] lineArray = line.toCharArray();
		
		for(int i = 0; i < MATRIX.length; i++){
			for(int j = 0; j < MATRIX[0].length; j++){ //assuming completely balanced matrix
				if(MATRIX[i][j] == lineArray[0]){if(checkADJ(lineArray, i, j, 1, false, false, false, false) == true) return true;}
			}//inner(j)
		}//outer(i)
		return false;
	}
	
	
	public static boolean checkADJ(char[] lineArray, int i, int j, int curr, boolean ip, boolean im, boolean jp, boolean jm){
		int end = lineArray.length-1;
		
		//flags to keep track of where we came from. important so that we don't revisit the same letter to form a word (i.e. SAS from 0, 1 going 0, 0, then 0, 1 again).
		boolean iP1 = ip;//i+1
		boolean iM1 = im;//i-1
		boolean jP1 = jp;//j+1
		boolean jM1 = jm;//j-1
		
		if(curr > end) return true; //our match has been made!
		
		if(jM1 == false && j-1 >= 0 && MATRIX[i][j-1] == lineArray[curr]){if(checkADJ(lineArray, i, j-1, curr+1, false, false, true, false) == true) return true;}//recursion magic !
		if(jP1 == false && j+1 < MATRIX[0].length && MATRIX[i][j+1] == lineArray[curr]){if(checkADJ(lineArray, i, j+1, curr+1, false, false, false, true) == true) return true;}
		if(iM1 == false && i-1 >= 0 && MATRIX[i-1][j] == lineArray[curr]){if(checkADJ(lineArray, i-1, j, curr+1, true, false, false, false) == true) return true;}
		if(iP1 == false && i+1 < MATRIX.length && MATRIX[i+1][j] == lineArray[curr]){if(checkADJ(lineArray, i+1, j, curr+1, false, true, false, false) == true) return true;}
		
		//OPTIONALLY CASES where we are wrapping around the board
		/*
		if(jM1 == false && j-1 < 0 && MATRIX[i][MATRIX[0].length-1] == lineArray[curr]){if(checkADJ(lineArray, i, MATRIX[0].length-1, curr+1, false, false, true, false) == true) return true;}
		if(jP1 == false && j+1 >= MATRIX[0].length && MATRIX[i][0] == lineArray[curr]){if(checkADJ(lineArray, i, 0, curr+1, false, false, false, true) == true) return true;}
		if(iM1 == false && i-1 < 0 && MATRIX[MATRIX.length-1][j] == lineArray[curr]){if(checkADJ(lineArray, MATRIX.length-1, j, curr+1, true, false, false, false) == true) return true;}
		if(iP1 == false && i+1 >= MATRIX.length && MATRIX[0][j] == lineArray[curr]){if(checkADJ(lineArray, 0, j, curr+1, false, true, false, false) == true) return true;}
		*/
		
		return false;//no match.
	}

}
