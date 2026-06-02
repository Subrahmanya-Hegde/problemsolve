package com.hegde.practice.arrays;

import java.util.ArrayList;
import java.util.List;

public class KingsSafePositions {

    private static final int QUEEN = 1;
    private static final int KNIGHT = 2;

    public static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public List<Position> findSafePositionsForKing(Position whiteQueen,
                                                   Position whiteKnight,
                                                   Position blackKing){
        int[][] opponentNextMoves = new int[8][8];
        markAttackPositions(opponentNextMoves, whiteQueen, QUEEN);
        markAttackPositions(opponentNextMoves, whiteKnight, KNIGHT);
        return findSafePositionsForKing(blackKing, opponentNextMoves);
    }

    public List<Position> findSafePositionsForKing(Position king, int[][] opponentMoves){
        int[][] kingDirection = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };
        List<Position> safePositions = new ArrayList<>();
        for(int[] direction: kingDirection){
            int newRow = king.row + direction[0];
            int newCol = king.col + direction[1];
            if (isValidPosition(newRow, newCol) && opponentMoves[newRow][newCol] == 0) {
                safePositions.add(new Position(newRow, newCol));
            }
        }
        return safePositions;
    }

    private void markAttackPositions(int[][] chessBoardNextMoves, Position piece, int pieceType){
        if (pieceType == QUEEN) {
            markQueenAttackPositions(chessBoardNextMoves, piece);
        } else if (pieceType == KNIGHT) {
            markKnightAttackPositions(chessBoardNextMoves, piece);
        }
    }

    private void markKnightAttackPositions(int[][] chessBoardNextMoves, Position piece) {
        int[][] knightMoves = {
                {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
                {1, -2}, {1, 2}, {2, -1}, {2, 1}
        };
        for(int[] move: knightMoves) {
            int newRow = piece.row + move[0];
            int newCol = piece.col + move[1];
            if (isValidPosition(newRow, newCol)) {
                chessBoardNextMoves[newRow][newCol] = KNIGHT;
            }
        }
    }

    private boolean isValidPosition(int row, int col) {
        return (row >= 0 && row < 8 && col >= 0 && col < 8);
    }

    private void markQueenAttackPositions(int[][] chessBoardNextMoves, Position piece) {
        int[][] queenDirections = {
                {-1, 0}, {1, 0}, {0, -1}, {0, 1},
                {-1, -1}, {-1, 1}, {1, -1}, {1, 1}
        };
        for(int[] direction: queenDirections){
            int newRow = piece.row + direction[0];
            int newCol = piece.col + direction[1];
            while(isValidPosition(newRow, newCol)){
                chessBoardNextMoves[newRow][newCol] = QUEEN;
                newRow += direction[0];
                newCol += direction[1];
            }
        }
    }
}
