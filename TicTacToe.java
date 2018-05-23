//Name: Tatiana Joseph
//FSUID: tj14
//Assigment 2

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    private static final int ROWS = 3, COLS = 3; //Lines 10-14 from www3.ntu.edu.sg
    private static int[][] board = new int[ROWS][COLS]; // game board in 2D array
    private static final int EMPTY = 0;
    private static final int X= 1;
    private static final int O= 2;
    private static String player2;
    private Scanner input;

    public TicTacToe(String p2)//Constructor identities player 2 and sets entire board empty
    {player2=p2;
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                board[i][j]=EMPTY;}

    public void Display() { //Lines 25-41 from www3.ntu.edu.sg
        System.out.print("\nGame Board:\t\tPositions:\n");
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col) {//Printing out Game Row
                printCell(board[row][col]);
                if (col != COLS - 1)
                    System.out.print("|");   // print vertical partition
            }
            if(row==0)
                System.out.print("\t\t1 | 2 | 3 ");
            else if(row==1)
                System.out.print("\t\t4 | 5 | 6 ");
            else
                System.out.print("\t\t7 | 8 | 9 ");
            System.out.println();
            if (row != ROWS - 1)
                System.out.println("-----------\t\t-----------"); // print horizontal partition
        }
        System.out.println();}

    public static void printCell(int content) {
        switch (content) {
            case EMPTY:  System.out.print("   "); break;
            case O: System.out.print(" O "); break;
            case X:  System.out.print(" X "); break;
        }}

    public void PlayerOneMove() {
        Display();
        //Take in User Input
        int move = 0;
        System.out.print("Player 1, please enter a move (1-9): ");
        input = new Scanner(System.in);
        move = input.nextInt();
        //Check if position already taken, if not place on  board. If invalid or taken, allow user to re-enter
        if (move == 1 && board[0][0] == EMPTY)
            board[0][0] = X;
        else if (move == 2 && board[0][1] == EMPTY)
            board[0][1] = X;
        else if (move == 3 && board[0][2] == EMPTY)
            board[0][2] = X;
        else if (move == 4 && board[1][0] == EMPTY)
            board[1][0] = X;
        else if (move == 5 && board[1][1] == EMPTY)
            board[1][1] = X;
        else if (move == 6 && board[1][2] == EMPTY)
            board[1][2] = X;
        else if (move == 7 && board[2][0] == EMPTY)
            board[2][0] = X;
        else if (move == 8 && board[2][1] == EMPTY)
            board[2][1] = X;
        else if (move == 9 && board[2][2] == EMPTY)
            board[2][2] = X;
        else {
            System.out.print("Invalid move. Please enter a move (1-9): ");
            move = input.nextInt();
            while (move < 0 || move > 9) {
                System.out.print("Invalid move. Please enter a move (1-9): ");
                move = input.nextInt();
            }
            if (move > 0 && move < 10) {
                while ((move < 4 && board[0][move - 1] != EMPTY) || (move > 3 && move < 7 && board[1][move - 4] != EMPTY) || (move > 6 && board[2][move - 7] != EMPTY)) {
                    System.out.print("Position already occupied. Please enter a move (1-9): ");
                    move = input.nextInt();
                }
                if (move < 4)
                    board[0][move - 1] = X;
                else if (move > 3 && move < 7)
                    board[1][move - 4] = X;
                else if (move > 6)
                    board[2][move - 7] = X;
            }
        }
    }
    public void PlayerTwoMove(){
        Display();
        //Take in User Input
        int move=0;
            System.out.print("Player 2, please enter a move (1-9): ");
            input = new Scanner(System.in);
            move=input.nextInt();
        if(move==1 && board[0][0]==EMPTY)
         board[0][0]=O;
        else if(move==2 && board[0][1]==EMPTY)
         board[0][1]=O;
        else if(move==3 && board[0][2]==EMPTY)
           board[0][2]=O;
        else if(move==4 && board[1][0]==EMPTY)
          board[1][0]=O;
        else if(move==5 && board[1][1]==EMPTY)
          board[1][1]=O;
        else if(move==6 && board[1][2]==EMPTY)
            board[1][2] = O;
        else if(move==7 && board[2][0]==EMPTY)
            board[2][0]=O;
        else if(move==8 && board[2][1]==EMPTY)
            board[2][1]=O;
        else if(move==9 && board[2][2]==EMPTY)
            board[2][2]=O;
        else {
            System.out.print("Invalid move. Please enter a move (1-9): ");
            move = input.nextInt();
            while (move < 0 || move > 9) {
                System.out.print("Invalid move. Please enter a move (1-9): ");
                move = input.nextInt();
            }
            if (move > 0 && move < 10) {
                while ((move < 4 && board[0][move - 1] != EMPTY) || (move > 3 && move < 7 && board[1][move - 4] != EMPTY) || (move > 6 && board[2][move - 7] != EMPTY) || move<1 || move>9) {
                    System.out.print("Invalid move. Please enter a move (1-9): ");
                    move = input.nextInt();
                }
                if (move < 4)
                    board[0][move - 1] = O;
                else if (move > 3 && move < 7)
                    board[1][move - 4] = O;
                else if (move > 6)
                    board[2][move - 7] = O;

            }

        }
    }

    public void Computer_Player() {
        Display();
        //Check for winning move
        //Horizontal wins
        System.out.print("Player 2 chooses position ");
        if (board[0][0] == EMPTY && board[0][1] == O && board[0][2] == O) {
            board[0][0] = O;
            System.out.print(1);
        } else if (board[0][0] == O && board[0][1] == EMPTY && board[0][2] == O) {
            board[0][1] = O;
            System.out.print(2);
        } else if (board[0][0] == O && board[0][1] == O && board[0][2] == EMPTY) {
            board[0][2] = O;
            System.out.print(3);
        } else if (board[1][0] == EMPTY && board[1][1] == O && board[1][2] == O) {
            board[1][0] = O;
            System.out.print(4);
        } else if (board[1][0] == O && board[1][1] == EMPTY && board[1][2] == O) {
            board[1][1] = O;
            System.out.print(5);
        } else if (board[1][0] == O && board[1][1] == O && board[1][2] == EMPTY) {
            board[1][2] = O;
            System.out.print(6);
        } else if (board[2][0] == EMPTY && board[2][1] == O && board[2][2] == O) {
            board[2][0] = O;
            System.out.print(7);
        } else if (board[2][0] == O && board[2][1] == EMPTY && board[2][2] == O) {
            board[2][1] = O;
            System.out.print(8);
        } else if (board[2][0] == O && board[2][1] == O && board[2][2] == EMPTY) {
            board[2][2] = O;
            System.out.print(9);
        }

        //Vertical wins
        else if (board[0][0] == EMPTY && board[1][0] == O && board[2][0] == O) {
            board[0][0] = O;
            System.out.print(1);
        } else if (board[0][0] == O && board[1][0] == EMPTY && board[2][0] == O) {
            board[1][0] = O;
            System.out.print(4);
        } else if (board[0][0] == O && board[1][0] == O && board[2][0] == EMPTY) {
            board[2][0] = O;
            System.out.print(7);
        } else if (board[0][1] == EMPTY && board[1][1] == O && board[2][1] == O) {
            board[0][1] = O;
            System.out.print(2);
        } else if (board[0][1] == O && board[1][1] == EMPTY && board[2][1] == O) {
            board[1][1] = O;
            System.out.print(5);
        } else if (board[0][1] == O && board[1][1] == O && board[2][1] == EMPTY) {
            board[2][1] = O;
            System.out.print(8);
        } else if (board[0][2] == EMPTY && board[1][2] == O && board[2][2] == O) {
            board[0][2] = O;
            System.out.print(3);
        } else if (board[0][2] == O && board[1][2] == EMPTY && board[2][2] == O) {
            board[1][2] = O;
            System.out.print(6);
        } else if (board[0][2] == O && board[1][2] == O && board[2][2] == EMPTY) {
            board[2][2] = O;
            System.out.print(9);
        }
        //Diagonal wins
        else if (board[0][0] == EMPTY && board[1][1] == O && board[2][2] == O) {
            board[0][0] = O;
            System.out.print(1);
        } else if (board[0][0] == O && board[1][1] == EMPTY && board[2][2] == O) {
            board[1][1] = O;
            System.out.print(5);
        } else if (board[0][0] == O && board[1][1] == O && board[2][2] == EMPTY) {
            board[2][2] = O;
            System.out.print(9);
        } else if (board[0][2] == EMPTY && board[1][1] == O && board[2][0] == O) {
            board[0][2] = O;
            System.out.print(3);
        } else if (board[0][2] == O && board[1][1] == EMPTY && board[2][0] == O) {
            board[1][1] = O;
            System.out.print(5);
        } else if (board[0][2] == O && board[1][1] == O && board[2][0] == EMPTY) {
            board[2][0] = O;
            System.out.print(7);
        }
        //If opponent threatening winning move, block it
        //Horizontal wins
        else if (board[0][0] == EMPTY && board[0][1] == X && board[0][2] == X) {
            board[0][0] = O;
            System.out.print(1);
        } else if (board[0][0] == X && board[0][1] == EMPTY && board[0][2] == X) {
            board[0][1] = O;
            System.out.print(2);
        } else if (board[0][0] == X && board[0][1] == X && board[0][2] == EMPTY) {
            board[0][2] = O;
            System.out.print(3);
        } else if (board[1][0] == EMPTY && board[1][1] == X && board[1][2] == X) {
            board[1][0] = O;
            System.out.print(4);
        } else if (board[1][0] == X && board[1][1] == EMPTY && board[1][2] == X) {
            board[1][1] = O;
            System.out.print(5);
        } else if (board[1][0] == X && board[1][1] == X && board[1][2] == EMPTY) {
            board[1][2] = O;
            System.out.print(6);
        } else if (board[2][0] == EMPTY && board[2][1] == X && board[2][2] == X) {
            board[2][0] = O;
            System.out.print(7);
        } else if (board[2][0] == X && board[2][1] == EMPTY && board[2][2] == X) {
            board[2][1] = O;
            System.out.print(8);
        } else if (board[2][0] == X && board[2][1] == X && board[2][2] == EMPTY) {
            board[2][2] = O;
            System.out.print(9);
        }

        //Vertical wins
        else if (board[0][0] == EMPTY && board[1][0] == X && board[2][0] == X) {
            board[0][0] = O;
            System.out.print(1);
        } else if (board[0][0] == X && board[1][0] == EMPTY && board[2][0] == X) {
            board[1][0] = O;
            System.out.print(4);
        } else if (board[0][0] == X && board[1][0] == X && board[2][0] == EMPTY) {
            board[2][0] = O;
            System.out.print(7);
        } else if (board[0][1] == EMPTY && board[1][1] == X && board[2][1] == X) {
            board[0][1] = O;
            System.out.print(2);
            return;
        } else if (board[0][1] == X && board[1][1] == EMPTY && board[2][1] == X) {
            board[1][1] = O;
            System.out.print(5);
        } else if (board[0][1] == X && board[1][1] == X && board[2][1] == EMPTY) {
            board[2][1] = O;
            System.out.print(8);
        } else if (board[0][2] == EMPTY && board[1][2] == X && board[2][2] == X) {
            board[0][2] = O;
            System.out.print(3);
        } else if (board[0][2] == X && board[1][2] == EMPTY && board[2][2] == X) {
            board[1][2] = O;
            System.out.print(6);
        } else if (board[0][2] == X && board[1][2] == X && board[2][2] == EMPTY) {
            board[2][2] = O;
            System.out.print(9);
        }
        //Diagonal wins
        else if (board[0][0] == EMPTY && board[1][1] == X && board[2][2] == X) {
            board[0][0] = O;
            System.out.print(1);
        } else if (board[0][0] == X && board[1][1] == EMPTY && board[2][2] == X) {
            board[1][1] = O;
            System.out.print(5);
        } else if (board[0][0] == X && board[1][1] == X && board[2][2] == EMPTY) {
            board[2][2] = O;
            System.out.print(9);
        } else if (board[0][2] == EMPTY && board[1][1] == X && board[2][0] == X) {
            board[0][2] = O;
            System.out.print(3);
        } else if (board[0][2] == X && board[1][1] == EMPTY && board[2][0] == X) {
            board[1][1] = O;
            System.out.print(5);
        } else if (board[0][2] == X && board[1][1] == X && board[2][0] == EMPTY) {
            board[2][0] = O;
            System.out.print(7);
        }
        //Take center move
        else if (board[1][1] == EMPTY)
        {board[1][1] = O;
            System.out.print(5+"\n");}
            //Randomly select a move that is not taken
        else {
            Random r = new Random();

            int i = r.nextInt(3)+0 ;
            int j = r.nextInt(3)+0 ;
            while (board[i][j] == X || board[i][j] == O) {
                i = r.nextInt(3 - 0) ;
                j = r.nextInt(3 - 0) ;
            }
            board[i][j] = O;
            if (i==0)
                System.out.println(j+1);
            else if(i==1)
                System.out.println(i+j+3);
            else if(i==2)
                System.out.println(i+j+5);

        }
        System.out.println("");
    }

    public boolean Win(){ //8 ways to win
        //If player 1 wins

        if(board[0][0]==X && board[0][1]==X && board[0][2]==X)
            {System.out.println("Player 1 Wins!!!");
            return true;}
        else if(board[0][0]==X && board[1][0]==X && board[2][0]==X)
            {System.out.println("Player 1 Wins!!!");
                return true;}
        else if(board[0][0]==X && board[1][1]==X && board[2][2]==X)
            {System.out.println("Player 1 Wins!!!");
                return true;}

        else if(board[0][1]==X && board[1][1]==X && board[2][1]==X)
            {System.out.println("Player 1 Wins!!!");
                return true;}
        else if(board[0][2]==X && board[1][1]==X && board[2][0]==X)
            {System.out.println("Player 1 Wins!!!");
                return true;}
        else if(board[0][2]==X && board[1][2]==X && board[2][2]==X)
            {System.out.println("Player 1 Wins!!!");
                return true;}
        else if(board[1][0]==X && board[1][1]==X && board[1][2]==X)
        {System.out.println("Player 1 Wins!!!");
            return true;}
        else if(board[2][0]==X && board[2][1]==X && board[2][2]==X)
        {System.out.println("Player 1 Wins!!!");
            return true;}

        //If player 2 wins
        else if(board[0][0]==O && board[0][1]==O && board[0][2]==O)
        {System.out.println("Player 2 Wins!!!");
            return true;}
        else if(board[0][0]==O && board[1][0]==O && board[2][0]==O)
            {System.out.println("Player 2 Wins!!!");
                return true;}
        else if(board[0][0]==O && board[1][1]==O && board[2][2]==O)
            {System.out.println("Player 2 Wins!!!");
                return true;}

        else if(board[0][1]==O && board[1][1]==O && board[2][1]==O)
            {System.out.println("Player 2 Wins!!!");
                return true;}

        else if(board[0][2]==O && board[1][1]==O && board[2][0]==O)
            {System.out.println("Player 2 Wins!!!");
                return true;}
        else if(board[0][2]==O && board[1][2]==O && board[2][2]==O)
            {System.out.println("Player 2 Wins!!!");
                return true;}

        else if(board[1][0]==O && board[1][1]==O && board[1][2]==O)
        {System.out.println("Player 2 Wins!!!");
            return true;}
        else if(board[2][0]==O && board[2][1]==O && board[2][2]==O)
        {System.out.println("Player 2 Wins!!!");
            return true;}
        return false;
    }
    public boolean Draw(){
        if(Win()==false){
            int count=0;
            for(int i=0;i<3;i++)
                for(int j=0;j<3;j++)
                    if(board[i][j]==EMPTY)
                        return false; //if any empty spots found, return false
        }
        System.out.print("It's a draw!!!");
        return true;
    }
    public static void main(String [] args)
    { TicTacToe game=new TicTacToe(args[0]); //Loop until win or draw
        while(game.Win()==false && game.Draw()==false){
           game.PlayerOneMove();
           if(game.Win()==true)
           { game.Display();
               break;}
           if(args[0].contains("-h"))
               game.PlayerTwoMove();
           else
               game.Computer_Player();
            if(game.Win()==true)
            { game.Display();
                break;}
           }
    }
}

