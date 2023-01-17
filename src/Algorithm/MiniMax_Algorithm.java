/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithm;

import java.util.Scanner;

/**
 *
 * @author Mohammad
 */
public class MiniMax_Algorithm{



// This function returns true if there are moves
// remaining on the board. It returns false if
// there are no moves left to play.
public static Boolean isMovesLeft(char board[][])
{
	for (int i = 0; i < 3; i++)
		for (int j = 0; j < 3; j++)
			if (board[i][j] == '_')
				return true;
	return false;
}

// This is the evaluation function as discussed
public static int evaluate(char b[][])
{
	// Checking for Rows for X or O victory.
	for (int row = 0; row < 3; row++)
	{
		if (b[row][0] == b[row][1] &&
			b[row][1] == b[row][2])
		{
			if (b[row][0] == Players.computer_player)
				return +10;
			else if (b[row][0] == Players.you_player)
				return -10;
		}
	}

	// Checking for Columns for X or O victory.
	for (int col = 0; col < 3; col++)
	{
		if (b[0][col] == b[1][col] &&
			b[1][col] == b[2][col])
		{
			if (b[0][col] == Players.computer_player)
				return +10;

			else if (b[0][col] == Players.you_player)
				return -10;
		}
	}

	// Checking for Diagonals for X or O victory.
	if (b[0][0] == b[1][1] && b[1][1] == b[2][2])
	{
		if (b[0][0] == Players.computer_player)
			return +10;
		else if (b[0][0] == Players.you_player)
			return -10;
	}

	if (b[0][2] == b[1][1] && b[1][1] == b[2][0])
	{
		if (b[0][2] == Players.computer_player)
			return +10;
		else if (b[0][2] == Players.you_player)
			return -10;
	}

	// Else if none of them have won then return 0
	return 0;
}

// This is the minimax function. It considers all
// the possible ways the game can go and returns
// the value of the board
static int minimax(char board[][],int depth, Boolean isMax)
{
	int score = evaluate(board);

	// If Maximizer has won the game
	// return his/her evaluated score
	if (score == 10)
		return score;

	// If Minimizer has won the game
	// return his/her evaluated score
	if (score == -10)
		return score;

	// If there are no more moves and
	// no winner then it is a tie
	if (isMovesLeft(board) == false)
		return 0;

	// If this maximizer's move
	if (isMax)
	{
		int best = -1000;

		// Traverse all cells
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				// Check if cell is empty
				if (board[i][j]=='_')
				{
					// Make the move
					board[i][j] = Players.computer_player;

					// Call minimax recursively and choose
					// the maximum value
					best = Math.max(best, minimax(board,
									depth + 1, !isMax));

					// Undo the move
					board[i][j] = '_';
				}
			}
		}
		return best;
	}

	// If this minimizer's move
	else
	{
		int best = 1000;

		// Traverse all cells
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				// Check if cell is empty
				if (board[i][j] == '_')
				{
					// Make the move
					board[i][j] = Players.you_player;

					// Call minimax recursively and choose
					// the minimum value
					best = Math.min(best, minimax(board,
									depth + 1, !isMax));

					// Undo the move
					board[i][j] = '_';
				}
			}
		}
		return best;
	}
}

// This will return the best possible
// move for the player
public static Move findBestMove(char board[][])
{
	int bestVal = -1000;
	Move bestMove = new Move();
	bestMove.row = -1;
	bestMove.col = -1;

	// Traverse all cells, evaluate minimax function
	// for all empty cells. And return the cell
	// with optimal value.
	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 3; j++)
		{
			// Check if cell is empty
			if (board[i][j] == '_')
			{
				// Make the move
				board[i][j] = Players.computer_player;

				// compute evaluation function for this
				// move.
				int moveVal = minimax(board, 0, false);

				// Undo the move
				board[i][j] = '_';

				// If the value of the current move is
				// more than the best value, then update
				// best/
				if (moveVal > bestVal)
				{
					bestMove.row = i;
					bestMove.col = j;
					bestVal = moveVal;
				}
			}
		}
	}


	return bestMove;
}

public static void  boardDisplay(char board[][]){
    for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            System.out.print(board[i][j]+" ");
        }
        System.out.println();
    }
}

//check from winner
public static String winner(int evaluate){
    switch(evaluate){
        case 10:
            return "You lost";
           
        case -10:
            return "You winn";
            
        case 0:
                return "Equality";
                
         default:
             return "Error";
                
    }
}

/*
// Driver code
public static void main(String[] args)
{
	char board[][] = {{ '_', '_', '_' },
			  { '_', '_', '_' },
			  { '_', '_', '_' }};
        boardDisplay(board);
        Scanner scanner=new Scanner(System.in);
        
        
        while (isMovesLeft(board)) { 
            System.out.println("Enter row: ");
            int row=scanner.nextInt();
            System.out.println("Enter col: ");
            int col=scanner.nextInt();
           
            board[row][col]='o';
            boardDisplay(board);
            if(!isMovesLeft(board)){
                break;
            }
            
            Move bestMove = findBestMove(board);
            board[bestMove.row][bestMove.col]='x';
            
            boardDisplay(board);
        }
        
        System.out.println(winner(evaluate(board)));
        
}
*/
}

