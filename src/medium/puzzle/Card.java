package medium.puzzle;

public class Card {

  int top;
  int right;
  int bottom;
  int left;

  public Card(int top, int right, int bottom, int left) {
    this.top = top;
    this.right = right;
    this.bottom = bottom;
    this.left = left;
  }


  private String stringify() {
    return String.valueOf(top) + String.valueOf(right)+String.valueOf(bottom) + String.valueOf(left);
  }

  @Override
  public int hashCode() {
    return stringify().hashCode();
  }

  @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
  @Override
  public boolean equals(Object obj) {
    Card other = (Card) obj;

    return top == other.top && right == other.right && bottom == other.bottom && left == other.left;
  }

  public Card turnRight() {
    //noinspection SuspiciousNameCombination
    return new Card(left, top, right, bottom);
  }
}
