// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
  private static final Character SHIP = '#';

  private void clearShipTiles(Boolean[][] board, int x, int y) {
    Boolean isBottomBound = y == board[0].length - 1;
    Boolean isLeftBound = x == 0;
    Boolean isRightBound = x == board.length - 1;
    Boolean isTopBound = y == 0;
    if (!isBottomBound) {
      board[x][y + 1] = false;
    }
    if (!isLeftBound) {
      board[x - 1][y] = false;
    }
    if (!isRightBound) {
      board[x + 1][y] = false;
    }
    if (!isTopBound) {
      board[x][y - 1] = false;
    }
  }

  private int countTouchingShipTiles(Boolean[][] board, int x, int y) {
    Boolean isBottomBound = y == board[0].length - 1;
    Boolean isLeftBound = x == 0;
    Boolean isRightBound = x == board.length - 1;
    Boolean isTopBound = y == 0;
    int touchingShipTiles = 0;
    if (!isBottomBound && board[x][y + 1]) {
      touchingShipTiles++;
    }
    if (!isLeftBound && board[x - 1][y]) {
      touchingShipTiles++;
    }
    if (!isRightBound && board[x + 1][y]) {
      touchingShipTiles++;
    }
    if (!isTopBound && board[x][y - 1]) {
      touchingShipTiles++;
    }
    return touchingShipTiles;
  }

  public int[] solution(String[] B) {
    int destroyerCount = 0;
    int patrolBoatCount = 0;
    int submarineCount = 0;

    Boolean[][] board = new Boolean[B.length][B[0].length()];
    for (int x = 0; x < B.length; x++) {
      for (int y = 0; y < B[x].length(); y++) {
        board[x][y] = B[x].charAt(y) == SHIP;
      }
    }

    for (int x = 0; x < board.length; x++) {
      for (int y = 0; y < board[0].length; y++) {
        if (board[x][y]) {
          int touchingShipTiles = countTouchingShipTiles(board, x, y);
          if (touchingShipTiles == 0) {
            patrolBoatCount++;
          } else if (touchingShipTiles == 1) {
            submarineCount++;
          } else if (touchingShipTiles == 2) {
            destroyerCount++;
          }
          clearShipTiles(board, x, y);
        }
      }
    }

    return new int[] { patrolBoatCount, submarineCount, destroyerCount };
  }
}
