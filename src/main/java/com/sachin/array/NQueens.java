package com.sachin.array;

public class NQueens {
  static int size = 4;

  public static void main(String[] args) {
    int[][] board = { { 0, 0, 0, 0 },
                      { 0, 0, 0, 0 },
                      { 0, 0, 0, 0 },
                      { 0, 0, 0, 0 } };
    if(findNQueenSol(board, 0)) {
      System.out.println("Solution exists !!!");
      printSolution(board);
    } else {
      System.out.println("Solution does not exists !!!");
    }

  }

  private static void printSolution(int[][] board) {
    for(int[] row : board) {
      for(int col : row) {
        System.out.print(col + "    ");
      }
      System.out.println();
    }
    
  }

  private static boolean findNQueenSol(int[][] board, int col) {
    if(col >= size) {
      return true;
    }
    
    for(int i = 0; i < size; i++) {
      if(isSafe(board, i, col)) {
        board[i][col] = 1;
        if(findNQueenSol(board, col +1)) {
          return true;
        }
        board[i][col] = 0;
      }
    }
    return false;
  }
  
  private static boolean isSafe(int[][] board, int row, int col) {
    int i, j;
    //check if this row contains any queen
    for(i = 0; i < col; i++) {
      if(board[row][i] == 1) {
        return false;
      }
    }
    
    //check upper diagonal contains any queen
    for(i = row - 1, j = col -1; i >=0 && j >= 0; i--, j--) {
      if(board[i][j] == 1) {
        return false;
      }
    }
    
    //check lower diagonal contains any queen
    for(i = row + 1, j = col -1; i <  size && j >= 0; i++, j--) {
      if(board[i][j] == 1) {
        return false;
      }
    }
    
    return true;
  }

}
