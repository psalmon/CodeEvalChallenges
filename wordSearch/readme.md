 Author: Paul Salmon
 Code Eval: Word Search (Hard Difficulty)
 Score: 97.5/100% (Possible error in grading system)
 
 "Given a 2D board and a word, find if the word exists in the grid. The word can be constructed from letters of sequentially adjacent cell, where adjacent cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once."
 
 The board is hard coded and constant.
 
 [
[ABCE],
[SFCS],
[ADEE]
]
 
 Program accepts argument to a filename. Input should be multiple lines of words to search for. Note that this is more of a "snake" search than a wordsearch, and we can only go in the 4 cardinal directions. This program determines whether a path along that exact word "route" exists.
 
 You cannot hit the same letter (unique, element specific letter) twice, which is why the code keeps track of where the recursion comes from.
 
sample input:
ASADB
ABCCED
ABCF
SAS

Note the last one should be false because we cannot turn hit the same element twice.

sample output:
False
True
False
False

The code makes use of many recursive calls, that way if we found a partial match, we still backtrack and examine all other possibilities. An example would be if we wanted ABF and the algorithm found ABC first; the recursion is used so that when the first set of calls fails, it eventually back tracks and does find ABF.

There is a segment commented out which will allow for looping around the borders.

This scores a 97.5% on code-eval but there is no reason why it should not be 100% that I can think of. I examined all 40 test cases myself (a bit of a perfectionist :-/) and verified that they evaluate properly. It must be an error in the grading scheme, or perhaps an unmentioned requirement.