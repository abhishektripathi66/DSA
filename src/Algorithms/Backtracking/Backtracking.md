# Backtracking Algorithm
The backtracking algorithm is usually used where you need to go down one path and then return to your previous step in order to continue onto another path. Think of a 2D grid where you would need to go from top left to bottom right and there are possible dead ends where you need to retrace your steps to try another path.

## General setup for Backtracking
* We begin by calling a recursive method
* You would need to set a base case for your recursive method
* You would then start a for loop to iterate through each element
* Inside the for loop, you may need to include some additional checks based on the problem but the loop will always have "Add to stack" -> "Recurse" -> "Pop off of stack" steps

## Time Complexity
Majority of the time, the time complexity will be exponential O(n<sup>m</sup>) since there will almost always be a decision tree involved.

## Applications
Possible applications of Backtracking are:
* Solving Sudoku puzzles
* Finding permutations, combinations or subsets
* Finding a path from A to B