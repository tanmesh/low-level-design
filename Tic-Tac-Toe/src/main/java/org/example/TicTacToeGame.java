package org.example;

import com.sun.tools.javac.util.Pair;
import org.example.Model.Board;
import org.example.Model.PieceType;
import org.example.Model.Player;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public Deque<Player> players;
    public Board board;

    public TicTacToeGame() {
        initializeGame();
    }

    private void initializeGame() {
        //creating 2 payers
        Player player1 = new Player("Player1", PieceType.O);
        Player player2 = new Player("Player2", PieceType.X);

        players = new LinkedList<>();
        players.add(player1);
        players.add(player2);

        // initialize board
        board = new Board(3);
    }

    public String startGame() {
        boolean noWinner = true;
        while (noWinner) {
            Player playerTurn = players.removeFirst();

            board.printBoard();
            List<Pair<Integer, Integer>> freeSpace = board.getFreeCells();
            if(freeSpace == null) {
                noWinner = false;
                continue;
            }

            // Read input from user
            System.out.println("Player: " + playerTurn.name + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String []values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputColumn = Integer.parseInt(values[1]);

            // Placing the piece
            boolean pieceAddedSuccessfully = board.addPiece(inputRow, inputColumn, playerTurn.pieceType);
            if(!pieceAddedSuccessfully) {
                System.out.println("Incorrect position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.pieceType);
            if(winner) {
                return playerTurn.name;
            }
        }
        return "Tie";
    }

    private boolean isThereWinner(int inputRow, int inputColumn, PieceType pieceType) {
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;
        boolean flag4 = true;

        for(int i=0; i<board.size; ++i) {
            if(board.board[inputRow][i] == null || board.board[inputRow][i].pieceType != pieceType) {
                flag1 = false;
            }
        }

        for(int i=0; i<board.size; ++i) {
            if(board.board[i][inputColumn] == null || board.board[i][inputColumn].pieceType != pieceType) {
                flag2 = false;
            }
        }

        for(int i=0, j=0; i<board.size; ++i, ++j) {
            if(board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                flag3 = false;
            }
        }

        for(int i=0, j=0; i<board.size; ++i, ++j) {
            if(board.board[j][i] == null || board.board[j][i].pieceType != pieceType) {
                flag4 = false;
            }
        }

        return flag1 || flag2 || flag3 || flag4;
    }
}
