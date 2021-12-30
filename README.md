# Maze Solver

This is a program that finds the best solution path for a maze using artificial intelligence. It takes a maze file as an input and can use 6 different AI based search algorithms to find the best solution path for that maze. The user can select the algorithm to apply for a given maze using the command line menu. After running the selected algorithm, program prints the results.


## Rules

* Maze consists of NxN tiles.
* Searching starts at the tile marked as 'S' (start tile).
* Searching ends at one of the tiles marked as 'G' (goal tile).
* Walls of the maze are denoted with '#'.
* Program can expand towards the right, down, left, up directions if there is no wall.
* Exploring to an empty tile marked as whitespace ' ' costs 1 unit.
* Exploring to a trap tile marked as 'T' costs 10 units.

## Algorithms Used

* A* Search
* Breadth First Search
* Depth First Search
* Greedy Best First Search
* Iterative Deepening Search
* Uniform Cost Search

## Test Mazes

Best solution path for [maze.txt](maze.txt) input file visualized:

```
       1   2   3   4   5   6   7   8

     # # # # # # # # # # # # # # # # #
 1   # . . . # . . . . . . . . . . . #
     # . # . # . # # #   # # # # # . #
 2   # . # . . .   T #   #         . #
     # . # # # # #   #   #   # # # . #
 3   # . . S #   #         T   G # . #
     #   #   #   # # # # #   # # # . # 
 4   #   #       #       #   #     . #
     #   #   #   #   #   #   # # # . #
 5   #   #   #   #   #   #   #   # . #
     #   # # #   #   #   #   #   # . #
 6   #               #   #   # G . . #
     #   # # # # # # #   #   # # #   #
 7   #               #   # T     # T #
     #   # # #   #   # # # # #   #   #
 8   #       #   #   # G         # G #
     # # # # # # # # # # # # # # # # #
```


Best solution path for [maze2.txt](maze2.txt) input file visualized:

```
       1   2   3   4   5   6   7   8

     # # # # # # # # # # # # # # # # #
 1   #                 G # . . . . . #
     #   # # # # # # # # # . #   # . #
 2   #         T # . . . # . # T # . #
     # # # # #   # . # . # . #   # . #
 3   #             . # . . .     # . #
     # # # # # # # . # # # # # # # . #
 4   #             S             # G #
     #   # # # # # # #   #   #   # # # 
 5   #   #               # T #   #   #
     #   #   # # # # # # #   #   #   #
 6   #   #                   #     T #
     #   # # # # # # # # #   #   #   #
 7   #     T   G # G         #   #   #
     #   # # # # # # # # # # #   #   #
 8   #                           # G #
     # # # # # # # # # # # # # # # # #
```
