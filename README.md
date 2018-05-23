# TicTacToe
The following program allows user(s) to play Tic Tac Toe. The program consists of 2 modes 2 player(-h) and
1 player(-c). To compile the following program, enter the commands:
        javac TicTacToe.java
        java TicTacToe -flag

The program allows users(s) to enter a position on the board that is not occupied and adheres to the traditional rules
of Tic Tac Toe. In 1 player computer mode, the program plays as player 2 and is represented by the Computer_Mode() function.
The function attempts to first take the center piece, if not available, attempts to block possible winning player one moves.
If not possible, the program attempts to make a game winning move and if not possible, the function accesses the Random
library to randomly select an unoccupied space. Once, a player has 3 in a row, the program announces the winner and the program
ends. If the game ends with a tie, the program announces a draw and the program ends.
