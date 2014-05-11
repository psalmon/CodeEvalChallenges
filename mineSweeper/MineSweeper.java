/**
 * CodeEval Challenge: MINESWEEPER  (Hard Difficulty)
 * See included ReadMe for usage. 
 * @author Paul Salmon 
 * www.github.com/psalmon
 * Score: 100%
 */

package mineSweeper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MineSweeper {
	static ArrayList<String> lineList = new ArrayList<String>();
	static ArrayList<LineMatrix> matrices = new ArrayList<LineMatrix>();
	
	public static void buildLineList(BufferedReader lines) throws IOException{
		String newLine = lines.readLine();
		do{
			if(newLine != null){lineList.add(newLine); newLine = lines.readLine();}
		}while(newLine != null); 
	}
	
	public static LineMatrix makeMatrix(String line){
		return(new LineMatrix(line));
	}
	
	public static void printMatrix(LineMatrix matrix){
		System.out.println(matrix.getOutput());
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// IO garbage. Basically we're just taking the input and then calling buildLineList, then addMatrix, then printMatrix.
		// The LineMatrix constructor will take care of all calculation calls within LineMatrix.java
		try{
		BufferedReader inputFile = new BufferedReader(new FileReader(args[0]));
		buildLineList(inputFile);
		}catch(Exception e){
			System.out.println("Had an issue with the supplied input. Check file & supplied args.");
		}
		
		for(String line : lineList){
			LineMatrix solvedMatrix = makeMatrix(line);
			printMatrix(solvedMatrix);
		}

	}//end main

}//end MineSweeper
