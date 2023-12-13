package org.example.Model;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public int size;
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public void printBoard() {
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                System.out.print(board[i][j] == null ? "    " : board[i][j].pieceType.name() + "   ");
                if (j != size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }

    public List<Pair<Integer, Integer>> getFreeCells() {
        List<Pair<Integer, Integer>> freeCeels = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (board[i][j] == null) {
                    Pair<Integer, Integer> cell = new Pair<>(i, j);
                    freeCeels.add(cell);
                }
            }
        }
        return freeCeels;
    }

    public boolean addPiece(int inputRow, int inputColumn, PieceType pieceType) {
        if(board[inputRow][inputColumn] != null) {
            return false;
        }
        board[inputRow][inputColumn] = new PlayingPiece(pieceType);
        return true;
    }
}
