package io.github.jroy.advent.twentytwenty.dayfive;

public class BoardingPass {
  private final int row;
  private final int column;
  private final int seatId;

  public BoardingPass(int row, int column) {
    this.row = row;
    this.column = column;
    this.seatId = (row * 8) + column;
  }

  public int getRow() {
    return row;
  }

  public int getColumn() {
    return column;
  }

  public int getSeatId() {
    return seatId;
  }

  @Override
  public String toString() {
    return "BoardingPass{" +
        "row=" + row +
        ", column=" + column +
        ", seatId=" + seatId +
        '}';
  }
}
