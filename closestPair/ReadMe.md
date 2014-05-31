 author: Paul Salmon
 CodeEval challenge "Closest Pair"
 Difficulty: Hard
 Score: 100%

Find the closest pair of points on a grid, and print the distance between them (rounded to 4 decimal places). Input file can contain multiple sets.
 
Supply a file directory as command line argument. Formatting as such:
 
Set size
x y
x y
...
Set size
x y
x y
...
0

Where set size is a single integer, denoting the number of points in that set. The next set begins on the line immediately following the last point in the prior set, starting with the set size integer.

File is terminated by a 0.

Sample input

5
0 2
6 67
43 71
39 107
189 140
6
0 7
14 200
432 710
22 500
189 143
120 212
0

Sample output

36.2215
184.0489

Notes:

An n lg n algorithm exists for the closest pairs problem. It is a recursive divide and conquer algorithm.
It works something like:
1)Sort all points by x coords.
2)Split into two sets.
3)Find left set minimum, find right set minimum.
4)Find the minimum where one point is on the left set and one is on the right set (This can be done in linear time, apparently)
5)Take the minimum of all 3 mins.

This approach is *only* faster if step 4 is accomplished in linear time. The naive approach takes us right back to my solution, which is quadratic. The way this is accomplished
is by recognizing a "sparsity property". The idea being that for every point in a set, you only need to consider points in a rectangular dimension of our sets minimum for x, and 2 times that minimum for y.

Source: http://en.wikipedia.org/wiki/Closest_pair_of_points_problem#Planar_case
