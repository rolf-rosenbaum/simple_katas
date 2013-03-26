package medium.puzzle;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class PuzzleTest {


  @Test
  public void oneCard() {
    Card card = new Card(1,2,3,4);

    assertThat(new Puzzle(card).solutions(), is(4));
  }

  @Test
  public void twoCards() {
    Card card1 = new Card(1,1,1,1);
    Card card2 = new Card(-1,-1,-1,-1);

    assertThat(new Puzzle(card1, card2).solutions(), is(2));
  }

}
