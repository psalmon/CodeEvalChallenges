/**
 * CodeEval Challenge: MINESWEEPER  (Hard Difficulty)
 * See included ReadMe for usage. 
 * @author Paul Salmon 
 * www.github.com/psalmon
 * Score: 100%
 */
 
We are provided an M*N matrix through command line input (text file dir).
Each line should indicate a new problem to solve.
The idea is to build an M*N matrix where '*' represents a mine and '.' represents an empty space.
Using this matrix we should be able to determine the number of mines adjacent to every empty ('.') space, and increment a counter for each spot.
 
Input is provided as: m,n;matrix in major order form
 
Sample Input:
3,5;**.........*...
4,4;*........*......

Sample Output:
**100332001*100
*10022101*101110