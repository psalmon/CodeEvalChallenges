/*
 * author: Paul Salmon
 * CodeEval challenge "Closest Pair"
 * Difficulty: Hard
 * Score: 100%
 * 
 * See readme for notes and usage.
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;


public class ClosestPair {

	public static void main(String[] args) throws Exception {
		BufferedReader inputFile =  new BufferedReader(new FileReader(args[0]));
		int max_size = 1;
		
		while(true){
			try{max_size = Integer.parseInt(inputFile.readLine());
			}catch(Exception e){inputFile.close(); System.out.println("Something went really wrong. Try turning it off an on again!"); System.exit(0);}
			
			if (max_size == 0){inputFile.close(); System.exit(0);}//reached end of file
			
			int[][] coordinates = new int[max_size][2];
			
			for(int i = 0; i < max_size; i++){
				String[] s = inputFile.readLine().split(" ");
				coordinates[i][0] = Integer.parseInt(s[0]);
				coordinates[i][1] = Integer.parseInt(s[1]);
			}
		
			double minDist = 10000;
		
			for(int i = 0; i < coordinates.length-2; i++){ //A divide and conquer n lg(n) algorithm exists, but it's neither obvious nor intuitive. Ask a math major.
				for(int j = i+1; j < coordinates.length-1; j++){
					double distance = getDist(coordinates[i][0], coordinates[i][1], coordinates[j][0], coordinates[j][1]);
					if (distance < minDist) minDist = distance;
				}
			}
		
			if (minDist == 10000) System.out.println("INFINITY");
			else System.out.printf("%.4f\n", minDist); //format to 4 decimals.
			
		}
		


	}
	
	
	public static double getDist(int Xa, int Ya, int Xb, int Yb){
		double c = 0;
		
		c = (double)Math.sqrt(Math.pow(Xa-Xb, 2)+Math.pow(Ya-Yb, 2)); //straight line formula: c = sqrt[ (Xa-Xb)^2 + (Ya-Yb)^2 ]
		
		return c;
		
	}

}
