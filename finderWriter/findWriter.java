/**
 * CodeEval Challenge: Finder Writer (Medium Difficulty)
 * See included ReadMe for usage. 
 * @author Paul Salmon 
 * www.github.com/psalmon
 * Score: 100%
 */

package findWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class findWriter {

	public static void main(String[] args) throws IOException{

		BufferedReader inputFile = ioSetup(args[0]);
		handleFile(inputFile);

	}
	
	public static BufferedReader ioSetup(String args) throws FileNotFoundException{
		String path = args;
		BufferedReader inputFile = new BufferedReader(new FileReader(path));
		return inputFile;
	}
	
	public static void handleFile(BufferedReader inputFile) throws IOException{
		String line = null; //terminating variable
		
		//do the encrypted part
		do{
			HashMap<Integer, Character> encrypted = new HashMap<Integer, Character>(); //rebuild our map for every line
			line = inputFile.readLine();
			if (line == null){break;} //end of file found
			int i = 0; //char place counter on line.
			char value = line.charAt(i);
			do{
				value = line.charAt(i);
				if(value != '|'){ encrypted.put(i+1, value); } //i+1 b/c the keys start at 1.
				i++;
			}while (value != '|');
			
		
			StringBuilder output = new StringBuilder();
			
			StringBuilder keys = new StringBuilder();
			List<Integer> keyList = new ArrayList<Integer>();
			
		//do the key part
		while(i < line.length()){
			keys.append(line.charAt(i));
			i++;
		}
		Scanner s = new Scanner(keys.toString());
		while (s.hasNextInt()){
			keyList.add(s.nextInt());
		}
		
		Integer[] keyArray = keyList.toArray(new Integer[keyList.size()]);
		
		for (Integer j : keyArray){
			output.append(encrypted.get(j));
		}
			
		
		System.out.println(output);
		s.close();
			
		}while (line != null);
		
	}
	

}
