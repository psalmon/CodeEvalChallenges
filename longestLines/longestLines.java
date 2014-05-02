/**
 * CodeEval Challenge: Longest Lines (Medium Difficulty)
 * See included ReadMe for usage. 
 * @author Paul Salmon 
 * www.github.com/psalmon
 * Score: 100%
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class longestLines {
	public int n = 0;	//we need the n largest strings.
	public String dir = "";
	BufferedReader inputFile;
	ArrayList<String> lineList = new ArrayList<String>();
	
	public longestLines(String dir) throws NumberFormatException, IOException{
		this.dir = dir;
		this.inputFile = new BufferedReader(new FileReader(dir));
		try{this.n = Integer.parseInt(inputFile.readLine());
		
		}catch(Exception e){
			System.out.println("First line may not be a number...exiting.");
			System.exit(1);
		}
		
	}

	public static void main(String[] args) throws IllegalArgumentException, IOException {
		longestLines cases = new longestLines(args[0]);
		cases.buildList(cases.inputFile);
		cases.quickSort(0, cases.lineList.size()-1);
		cases.printLines();
		cases.inputFile.close();	//cleanup
		}
	
	public void buildList(BufferedReader lines) throws IOException{
		String newLine = lines.readLine();
		do{
			if(newLine != null){lineList.add(newLine); newLine = lines.readLine();}
		}while(newLine != null); 
	}
	


	public int countLine(String line){	
		return line.trim().length();	//ignore whitespace leading&trailing
	}
	
	public void quickSort(int start, int end){
		int i = start;
		int j = end;
		
		if (end - start >= 1){
			String pivot = lineList.get(start);
			while (j > i)	//when left and right indicies meet we are done with this iteration
			{
				while (countLine(lineList.get(i)) <= countLine(pivot) && i <= end && j > i){
					i++;
				}
				
				while (countLine(lineList.get(j)) > countLine(pivot) && j >= start && j >= i){
					j--;
				}
				
				if (j > i){
					swap(i, j);
				}
			}//end while
				
				swap(start, j);
				quickSort(start, j-1);
				quickSort(j+1, end);
			
			}else{		//end if
				return; //array is sorted
			}
			
		}
	
	public void swap(int i, int j){
		String temp = lineList.get(i);
		lineList.set(i, lineList.get(j));
		lineList.set(j, temp);
	}
	
	public void printLines(){
		int count = 0;
		while(count != n){
			System.out.println(lineList.get(lineList.size()-count-1));
			count++;
		}
		
	}
	
	
	


}//end longestLines
